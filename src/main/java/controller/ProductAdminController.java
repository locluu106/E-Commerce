/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.AgeGroupEntity;
import entity.ColorEntity;
import entity.ImagesEntity;
import entity.ProductDetailsEntity;
import entity.ProductEntity;
import entity.SexEntity;
import entity.SizeEntity;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import repository.AgeGroupRepository;
import repository.ColorRepository;
import repository.ImagesRepository;
import repository.ProductDetailsRepository;
import repository.ProductRepository;
import repository.SexRepository;
import repository.SizeRepository;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "/")
public class ProductAdminController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ProductDetailsRepository productDetailsRepo;

    @Autowired
    SexRepository sexRepo;

    @Autowired
    SizeRepository sizeRepo;

    @Autowired
    ColorRepository colorRepo;

    @Autowired
    AgeGroupRepository ageRepo;

    @Autowired
    ImagesRepository imagesRepo;

    @RequestMapping(value = "/listPro", method = RequestMethod.GET)
    public String showProduct(Model model) {
        List<ProductEntity> proList = (List<ProductEntity>) productRepo.findAll();
        model.addAttribute("proList", proList);

        return "admin/listManufacture";

    }

    @RequestMapping(value = "/deletePro/{productId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(value = "productId") int productId, Model model) {

        try {
            productRepo.deleteById(productId);
            List<ProductEntity> proList = (List<ProductEntity>) productRepo.findAll();
            model.addAttribute("proList", proList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "redirect:/listPro";
    }

    @RequestMapping(value = "/viewProduct/{id}", method = RequestMethod.GET)
    public String getListProductfindDetails(@PathVariable(value = "id") int id, Model model, HttpSession session) {

        List<ProductDetailsEntity> proList = (List<ProductDetailsEntity>) productDetailsRepo.getProductfindProductDetails(id);
        model.addAttribute("proList", proList);
        return "admin/viewDetails";
    }

    //---Edit---//
    @RequestMapping(value = "/editPro/{productId}", method = RequestMethod.GET)
    public String showEditCustomer(@PathVariable(value = "productId") int productId, Model model) {
        ProductEntity product = productRepo.findByProductId(productId);
        model.addAttribute("product", product);

        return "admin/editManufacture";
    }

    @RequestMapping(value = "/updatePro", method = RequestMethod.POST)
    public String updateCustomer(ProductEntity product, Model model) {

        productRepo.save(product);

        return "redirect:/listPro";
    }

    @RequestMapping(value = "/addPro", method = RequestMethod.GET)
    public String setupManufacture(Model model) {
        model.addAttribute("product", new ProductEntity());

        return "admin/addManufacture";
    }

    //save 
    @RequestMapping(value = "/addPro", method = RequestMethod.POST)
    public String saveSetupManufacture(ProductEntity product, Model model) {
        productRepo.save(product);
        model.addAttribute("product", new ProductEntity());

        return "redirect:/listPro";
    }

    //---Product Details---//    
    @RequestMapping(value = "/listProductDetails", method = RequestMethod.GET)
    public String showProductDetails(Model model) {
        List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.getAllProduct1();
        model.addAttribute("productDetailsList", productDetailsList);

        return "admin/listProductDetails";
    }

    //--Add--//
    @RequestMapping(value = "/setup", method = RequestMethod.GET)
    public String setupProductDetails(Model model) {
        model.addAttribute("productDetails", new ProductDetailsEntity());

        setProductDropdownList(model);
        setAgeGroupDropdownList(model);
        setColorDropdownList(model);
        setSexDropdownList(model);
        setSizeDropdownList(model);

        return "admin/addNew";
    }

    @RequestMapping(value = "/setup", method = RequestMethod.POST)
    public String saveNewProductDetails(@RequestParam("file") MultipartFile file,
            ProductDetailsEntity productDetails, ImagesEntity images, Model model) {

        try {
            byte[] bytes = file.getBytes();
            // Creating the directory to store file
            String pathName1 = "E:\\JavaSpring\\NetBeansProjects\\DemoECommerce\\src\\main\\webapp\\images";
            File dir1 = new File(pathName1);
            if (!dir1.exists()) {
                dir1.mkdirs();
            }

            // Create the file on server
            String fileSource1 = dir1.getAbsolutePath() + File.separator
                    + file.getOriginalFilename();
            File serverFile1 = new File(fileSource1);
            BufferedOutputStream stream1
                    = new BufferedOutputStream(new FileOutputStream(serverFile1));
            stream1.write(bytes);
            stream1.close();

            String fileName = file.getOriginalFilename();
            
            
            
            
//            productDetails.setImages(newImg);       

            model.addAttribute("productDetails", new ProductDetailsEntity());
            productDetailsRepo.save(productDetails);
            
            ImagesEntity newImg = new ImagesEntity();
            newImg.setImagesName(fileName);
            newImg.setProductDetails(productDetails);
            imagesRepo.save(newImg);
            
            
            return "redirect:/listProductDetails";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/listProductDetails";
        }
    }

    private void setProductDropdownList(Model model) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
        if (!productList.isEmpty()) {
            Map<Integer, String> productMap = new LinkedHashMap<>();

            for (ProductEntity product : productList) {
                productMap.put(product.getProductId(), product.getProductName());
            }
            model.addAttribute("productList", productMap);
        }
    }

    private void setSexDropdownList(Model model) {
        List<SexEntity> sexList = (List<SexEntity>) sexRepo.findAll();
        if (!sexList.isEmpty()) {
            Map<Integer, String> sexMap = new LinkedHashMap<>();

            for (SexEntity sex : sexList) {
                sexMap.put(sex.getSexId(), sex.getSexName());
            }
            model.addAttribute("sexList", sexMap);
        }
    }

    private void setColorDropdownList(Model model) {
        List<ColorEntity> colorList = (List<ColorEntity>) colorRepo.findAll();
        if (!colorList.isEmpty()) {
            Map<Integer, String> colorMap = new LinkedHashMap<>();

            for (ColorEntity color : colorList) {
                colorMap.put(color.getColorId(), color.getColorName());
            }
            model.addAttribute("colorList", colorMap);
        }
    }

    private void setAgeGroupDropdownList(Model model) {
        List<AgeGroupEntity> ageGroupList = (List<AgeGroupEntity>) ageRepo.findAll();
        if (!ageGroupList.isEmpty()) {
            Map<Integer, String> ageGroupMap = new LinkedHashMap<>();

            for (AgeGroupEntity ageGroup : ageGroupList) {
                ageGroupMap.put(ageGroup.getAgeGroupId(), ageGroup.getAgeName());
            }
            model.addAttribute("ageGroupList", ageGroupMap);
        }
    }

    private void setSizeDropdownList(Model model) {
        List<SizeEntity> sizeList = (List<SizeEntity>) sizeRepo.findAll();
        if (!sizeList.isEmpty()) {
            Map<Integer, String> sizeMap = new LinkedHashMap<>();

            for (SizeEntity size : sizeList) {
                sizeMap.put(size.getSizeId(), size.getSizeName());
            }
            model.addAttribute("sizeList", sizeMap);
        }
    }

    //Edit 
    @RequestMapping(value = "/edit/{productDetailsId}", method = RequestMethod.GET)
    public String showUpdateProductDetails(@PathVariable(value = "productDetailsId") int productDetailsId, Model model) {
        ProductDetailsEntity productDetails = productDetailsRepo.findByProductDetailsId(productDetailsId);
        model.addAttribute("productDetails", productDetails);

        setProductDropdownList(model);
        setAgeGroupDropdownList(model);
        setColorDropdownList(model);
        setSexDropdownList(model);
        setSizeDropdownList(model);

        return "admin/edit";
    }

    //update 
    @RequestMapping(value = "/updateProductDetails", method = RequestMethod.POST)
    public String updateProductDetails(@RequestParam("file") MultipartFile file,
            ProductDetailsEntity productDetails, ImagesEntity images, Model model) {

        try {
            byte[] bytes = file.getBytes();
            // Creating the directory to store file
            String pathName1 = "E:\\JavaSpring\\NetBeansProjects\\DemoECommerce\\src\\main\\webapp\\images";
            File dir1 = new File(pathName1);
            if (!dir1.exists()) {
                dir1.mkdirs();
            }

            // Create the file on server
            String fileSource1 = dir1.getAbsolutePath() + File.separator
                    + file.getOriginalFilename();
            File serverFile1 = new File(fileSource1);
            BufferedOutputStream stream1
                    = new BufferedOutputStream(new FileOutputStream(serverFile1));
            stream1.write(bytes);
            stream1.close();
            
            String fileName = file.getOriginalFilename();
            
            
            
            
//            productDetails.setImages(newImg);       

            model.addAttribute("productDetails", new ProductDetailsEntity());
            productDetailsRepo.save(productDetails);
            List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.findAll();
            
            imagesRepo.delete(images);
            
            ImagesEntity newImages = new ImagesEntity();
            newImages.setImagesName(fileName);
            newImages.setProductDetails(productDetails);
            imagesRepo.save(newImages);
            
            
            return "redirect:/view-all-product/1";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/view-all-product/1";
        }
    }

    //Delete
    @RequestMapping(value = "/delete/{productDetailsId}", method = RequestMethod.GET)
    public String deleteProductDetails(@PathVariable(value = "productDetailsId") int productDetailsId, Model model) {

        try {
            productDetailsRepo.deleteById(productDetailsId);
            imagesRepo.deleteById(productDetailsId);
            List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.findAll();
            model.addAttribute("productDetailsList", productDetailsList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "redirect:/listProductDetails";
    }
//--Phan Trang--//

    @RequestMapping(value = "/view-all-product/{pageProductId}", method = RequestMethod.GET)
    public String showAllProductDetails(@PathVariable int pageProductId, Model model) {

        int countProduct = productDetailsRepo.getCountProduct();
        int limitProduct = 10;
        if (pageProductId == 1) {
        } else {
            pageProductId = (pageProductId - 1) * limitProduct + 1;
        }
        List<ProductDetailsEntity> productDetailsList = productDetailsRepo.getAllProduct((pageProductId - 1), limitProduct);

        model.addAttribute("productDetailsList", productDetailsList);
        model.addAttribute("countProduct", countProduct);

        return "admin/listProductDetails";
    }

}
