package com.julliet.mineralproductmngt_sys.controller;
import com.julliet.mineralproductmngt_sys.model.Minerals;
import com.julliet.mineralproductmngt_sys.service.DatabasePDFService;
import com.julliet.mineralproductmngt_sys.service.MineralsService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class MineralsController {

    @Autowired
    MineralsService mineralsService;


    @GetMapping("/home")
    public String homePage(Model model){
        return findPaginated(1,model);
    }


    @GetMapping ("/search")
    public String searchMethod(Model model){
        model.addAttribute("search",new Minerals());
        return "findOne";
    }

    @PostMapping("/search")
    public String getEmployee(@ModelAttribute("search") Minerals minerals, Model model){
        Minerals minerals1= mineralsService.findMinerals(minerals.getOrder_id());
       if (minerals1!=null) {
           model.addAttribute("soldier1",minerals1);
           return "findOne";
       }
           model.addAttribute("error","He/She is not found");
           return "findOne";

    }


    @GetMapping("/employee_page")
    public String getEmployee(Model model){
        Minerals minerals=new Minerals();
        model.addAttribute("student",minerals);
        return "Minerals_page";
    }


    @GetMapping("/reg")
    public String registerStudentPage(Model model){
        Minerals minerals=new Minerals();
        model.addAttribute("student", minerals);
        return "registration-page";
    }

    @PostMapping("/registerM")
    public String registerMinerals(@ModelAttribute("student") @Validated Minerals theSoldier,BindingResult result) throws ParseException {
        Minerals savedSoldier = mineralsService.saveMinerals(theSoldier);
        if(savedSoldier != null){
            return "redirect:/employee_page?success";
        }
        return "redirect:/employee_page?error";
    }


    @PostMapping("/register")
    public String registerMin(@ModelAttribute("student") @Validated Minerals theSoldier, BindingResult result) throws ParseException {
        Minerals savedSoldier = mineralsService.saveMinerals(theSoldier);
        if(savedSoldier != null){
            return "redirect:/reg?success";
        }
        return "redirect:/reg?error";
    }

    @GetMapping("/home/edit/{studentID}")
    public String editStudent(@PathVariable String studentID, Model model){
        Long soldierId=Long.parseLong(studentID);
        model.addAttribute("student", mineralsService.findMinerals(soldierId));
        return "edit-page";
    }

    @PostMapping("/home/{studentID}")
    public String updateStudent(@PathVariable String studentID,@ModelAttribute("student") @Validated Minerals minerals1,BindingResult result){
        Long soldierId=Long.parseLong(studentID);
        Minerals minerals= mineralsService.findMinerals(soldierId);
        if (minerals!=null){
            minerals.setOrder_id(minerals1.getOrder_id());

            minerals.setMineral_type(minerals1.getMineral_type());

            minerals.setCustomer_name(minerals1.getCustomer_name());

            minerals.setCustomer_email(minerals1.getCustomer_email());

            minerals.setCustomer_phone(minerals1.getCustomer_phone());

            minerals.setCustomer_picture(minerals1.getCustomer_picture());

            mineralsService.updateMinerals(minerals);
            return "redirect:/home";
        }

        return "home-page";
    }
    @GetMapping ("/home/{studentID}")
    public String detleteStudent(@PathVariable String studentID ){
        Long solderId=Long.parseLong(studentID);
        mineralsService.deleteMinerals(solderId);
        return "redirect:/home";
    }

    @GetMapping("/exportCsv")
    public void exportCSV(HttpServletResponse response)
            throws Exception {

        //set file name and content type
        String filename = "Volunteer-data.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<Minerals> writer = new StatefulBeanToCsvBuilder<Minerals>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();
        //write all employees data to csv file
        writer.write(mineralsService.getAllMinerals());

    }

    @GetMapping(value = "/exportPdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> volunteerReport()  throws IOException {
        List<Minerals> volunteers = (List<Minerals>) mineralsService.getAllMinerals();
        ByteArrayInputStream bis = DatabasePDFService.employeePDFReport(volunteers);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=VolunteerReport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,Model model){
        int pageSize=5;
        Page<Minerals> page=mineralsService.pagenateStudent(pageNo,pageSize);
        List<Minerals> studentList=page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPage",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listStudents",studentList);
        return "home-page";
    }
}
