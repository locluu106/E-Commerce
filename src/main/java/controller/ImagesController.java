package controller;

import entity.ImagesEntity;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import repository.ImagesRepository;

@Controller
@RequestMapping(value = "/")
public class ImagesController {

    @Autowired
    ImagesRepository imagesRepo;

    //---Images---//
    @RequestMapping(value = "/listImg", method = RequestMethod.GET)
    public String showImages(Model model) {
        List<ImagesEntity> imagesList = (List<ImagesEntity>) imagesRepo.getAllImages1();
        model.addAttribute("imagesList", imagesList);

        return "admin/listImages";
    }

    @RequestMapping(value = "/addImage", method = RequestMethod.GET)
    public String addNewImages(Model model) {
        model.addAttribute("images", new ImagesEntity());
        return "admin/addImages";
    }

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public String saveNewImages(@RequestParam("file") MultipartFile file,
            ImagesEntity images, Model model) {
        try {
            byte[] bytes = file.getBytes();
            // Creating the directory to store file
            String pathName1 = "E:\\JavaSpring\\NetBeansProjects\\DemoECommerce\\src\\main\\webapp\\images";
            File dir1 = new File(pathName1);
            if (!dir1.exists()) {
                dir1.mkdirs();
            }

            String pathName2 = "E:\\JavaSpring\\NetBeansProjects\\DemoECommerce\\src\\main\\webapp\\images";
            File dir2 = new File(pathName2);
            if (!dir2.exists()) {
                dir2.mkdirs();
            }

            // Create the file on server
            String fileSource1 = dir1.getAbsolutePath() + File.separator
                    + file.getOriginalFilename();
            File serverFile1 = new File(fileSource1);
            BufferedOutputStream stream1
                    = new BufferedOutputStream(new FileOutputStream(serverFile1));
            stream1.write(bytes);
            stream1.close();

            String fileSource2 = dir2.getAbsolutePath() + File.separator
                    + file.getOriginalFilename();
            File serverFile2 = new File(fileSource2);
            BufferedOutputStream stream2
                    = new BufferedOutputStream(new FileOutputStream(serverFile2));
            stream2.write(bytes);
            stream2.close();

            String fileName = file.getOriginalFilename();
            //model.addAttribute("filename", fileName);

            images.setImagesName(fileName);
            model.addAttribute("images", images);
            imagesRepo.save(images);
            return "redirect:/listImg";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/listImg";
        }
    }

    //Delete Image
    @RequestMapping(value = "/deleteImage/{imagesId}", method = RequestMethod.GET)
    public String deleteImage(@PathVariable(value = "imagesId") int imagesId,
            Model model) {

        try {
            imagesRepo.deleteById(imagesId);
        } catch (Exception e) {
            System.out.println(e);
        }

        List<ImagesEntity> imagesList = (List<ImagesEntity>) imagesRepo.findAll();

        return "redirect:/listImg";
    }

    //---Phan Trang---//
    @RequestMapping(value = "/pageImages/{pageImagesId}", method = RequestMethod.GET)
    public String showAllImages(@PathVariable int pageImagesId, Model model) {

        int countImages = imagesRepo.getCountImages();
        int limitImages = 10;
        if (pageImagesId == 1) {
        } else {
            pageImagesId = (pageImagesId - 1) * limitImages + 1;
        }
        List<ImagesEntity> imagesList = imagesRepo.getAllImages((pageImagesId - 1), limitImages);

        model.addAttribute("imagesList", imagesList);
        model.addAttribute("countImages", countImages);

        return "admin/listImages";
    }
}
