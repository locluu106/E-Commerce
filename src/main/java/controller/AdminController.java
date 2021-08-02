package controller;

import entity.CategoryEntity;
import entity.CustomerEntity;
import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import entity.ProductEntity;
import entity.UserEntity;
import entity.UserRoleEntity;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import repository.CategoryRepository;
import repository.CustomerRepository;
import repository.OrderDetailsRepository;
import repository.OrdersRepository;

import repository.ProductRepository;
import repository.UserRepository;
import repository.UserRoleRepository;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    ProductRepository proRepo;

    @Autowired
    CategoryRepository cateRepo;

    @Autowired
    OrdersRepository ordersRepo;

    @Autowired
    UserRepository userRepo;
    
    @Autowired
    UserRoleRepository roleRepo;
    
    @Autowired
    CustomerRepository CustomerRepo;
    
   @Autowired
    OrderDetailsRepository OrderDetailsRepo;

    @RequestMapping("/index")
    public String homeAdmin(Model model) {
       
        return "admin/index";
    }

    @GetMapping("/uesr")
    public String showUser(Model model) {
        List<UserEntity> user = (List<UserEntity>) userRepo.findAll();
        model.addAttribute("user", user);
        return "admin/user";
    }
    
    
    
    @GetMapping("/orderDetails/{ordersId}")
    public String showOrderDetails(@PathVariable(value = "ordersId") int ordersId, Model model) {
        List<OrderDetailsEntity> orderDetailsList = (List<OrderDetailsEntity>) OrderDetailsRepo
                .getOrderDetails(ordersId);
        model.addAttribute("orderDetailsList", orderDetailsList);
        return "admin/show-orderdetail";
    }

    @GetMapping("/show-productDetails")
    public String showProduct(Model model,
            @RequestParam(name = "p", defaultValue = "0") int page) {
        List<ProductEntity> product = (List<ProductEntity>) proRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(product);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        model.addAttribute("pagedListHolder", pagedListHolder);
        return "admin/show-product";
    }

    @GetMapping("/add-Product")
    public String addNewProduct(Model model) {
        ProductEntity product = new ProductEntity();
        setCategoryDrop(model);
        model.addAttribute("product", product);
        return "admin/add_product";
    }

    @PostMapping(value = "/save-Product")
    public String saveNewProductDetails(@RequestParam("file") CommonsMultipartFile file, ProductEntity product,
            Model model) {

        try {
            byte[] bytes = file.getBytes();
            String pathName1 = "E:\\Spring2\\EcommerceFashion\\src\\main\\webapp\\images";
            File dir1 = new File(pathName1);
            if (!dir1.exists()) {
                dir1.mkdirs();
            }
            String name = dir1.getAbsolutePath() + File.separator + file.getOriginalFilename();
            File serverFile = new File(name);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

            String fileName = file.getOriginalFilename();
            product.setImages(fileName);
            proRepo.save(product);

            return "redirect:/admin/show-productDetails";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/admin/show-productDetails";
        }
    }

    @GetMapping(value = "/edit-Product/{productId}")
    public ModelAndView editProductDetails(@PathVariable(value = "productId") int productId, Model model) {
        ModelAndView editProduct = new ModelAndView("admin/edit-product");
        ProductEntity product = proRepo.findByProductId(productId);
        model.addAttribute("productDetais", product);

        setCategoryDrop(model);

        return editProduct;
    }

    @PostMapping(value = "/update-Product")
    public String updateProduct(@RequestParam("file") MultipartFile file,
            
            ProductEntity product, Model model) {
        try {
            byte[] bytes = file.getBytes();
            String pathName1 = "E:\\Spring2\\EcommerceFashion\\src\\main\\webapp\\images";
            File dir1 = new File(pathName1);
            if (!dir1.exists()) {
                dir1.mkdirs();
            }
            String name = dir1.getAbsolutePath() + File.separator + file.getOriginalFilename();
            File serverFile = new File(name);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

            String fileName = file.getOriginalFilename();
            product.setImages(fileName);
            proRepo.save(product);
            return "redirect:/admin/show-productDetails";
        } catch (Exception e) {
            System.out.println(e);
             setCategoryDrop(model);
             model.addAttribute("productDetais", product);
            return "admin/edit-product";
        }
    }

    @GetMapping("/add-Category")
    public String addNewCategory(Model model) {
        CategoryEntity category = new CategoryEntity();
        model.addAttribute("category", category);
        return "admin/addCate";
    }

    @PostMapping(value = "/save-Cate")
    public String saveNewCate(@Valid CategoryEntity category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            
            model.addAttribute("category", category);
            return "admin/addCate";
        }
        cateRepo.save(category);

        return "redirect:/admin/show-productDetails";
    }

    private void setCategoryDrop(Model model) {
        List<CategoryEntity> categoryList = (List<CategoryEntity>) cateRepo.findAll();
        if (!categoryList.isEmpty()) {
            Map<Integer, String> categoryMap = new LinkedHashMap<>();
            for (CategoryEntity category : categoryList) {
                categoryMap.put(category.getCategoryId(), category.getName());
            }
            model.addAttribute("categoryList", categoryMap);
        }
    }
    @GetMapping(value = "/Register")
    public String searchRegister(@RequestParam(name = "formDate") Date form,
            @RequestParam(name = "toDate") Date to
            , Model model) {

        LocalDate dateForm = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(form));
        LocalDate dateFto = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(to));

        List<UserEntity> user = userRepo.findByRegisterDateBetween(dateForm, dateFto);
        model.addAttribute("user", user);
     
        model.addAttribute("formDate", dateForm);
        model.addAttribute("toDate", dateFto);

        return "admin/user";
    }

    @RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
    public String searchProduct(@RequestParam(name = "searchText") String searchText, String searchText1,
            @RequestParam(name = "p", defaultValue = "0") int page, Model model) {
        searchText1 = "%" + searchText + "%";
        List<ProductEntity> productList = proRepo.findByNameLike(searchText1);
        PagedListHolder pagedListHolder = new PagedListHolder(productList);
        pagedListHolder.setPage(page);
        pagedListHolder.setSource(productList);
        pagedListHolder.setPageSize(3);
        model.addAttribute("pagedListHolder", pagedListHolder);
        model.addAttribute("searchText", searchText);

        return "admin/show-product";
    }

    @GetMapping("/show-Order")
    public ModelAndView showOrderList(Model model, @RequestParam(name = "p", defaultValue = "0") int page) {
        ModelAndView showOrders = new ModelAndView("admin/show-order");
        List<OrdersEntity> ordersList = (List<OrdersEntity>) ordersRepo.findAll();
        PagedListHolder pagedListHolder = new PagedListHolder(ordersList);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        model.addAttribute("pagedListHolder", pagedListHolder);

        return showOrders;
    }

    @GetMapping(value = "/searchDate")
    public String searchDate(@RequestParam(name = "formDate") Date form,
            @RequestParam(name = "toDate") Date to,@RequestParam(name = "p", defaultValue = "0") int page, Model model) {

        LocalDate dateForm = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(form));
        LocalDate dateFto = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(to));

        List<OrdersEntity> ordersList = ordersRepo.findByOrderDateBetween(dateForm, dateFto);
        PagedListHolder pagedListHolder = new PagedListHolder(ordersList);
        pagedListHolder.setPage(page);
        pagedListHolder.setSource(ordersList);
        pagedListHolder.setPageSize(6);
        model.addAttribute("pagedListHolder", pagedListHolder);
     
        model.addAttribute("formDate", dateForm);
        model.addAttribute("toDate", dateFto);

        return "admin/show-order";
    }

    @RequestMapping(value = "/searchOrder", method = RequestMethod.GET)
    public String searchOrder(@RequestParam(name = "searchText") String searchText,
            @RequestParam(name = "p", defaultValue = "0") int page, Model model) {

        List<OrdersEntity> ordersList = ordersRepo.searchOrders(searchText, searchText);
        PagedListHolder pagedListHolder = new PagedListHolder(ordersList);
        pagedListHolder.setPage(page);
        pagedListHolder.setSource(ordersList);
        pagedListHolder.setPageSize(3);
        model.addAttribute("pagedListHolder", pagedListHolder);

        model.addAttribute("searchTex", searchText);

        return "admin/show-order";
    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final LocalDate locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
