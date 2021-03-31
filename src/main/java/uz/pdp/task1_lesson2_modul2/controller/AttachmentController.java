package uz.pdp.task1_lesson2_modul2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.task1_lesson2_modul2.entity.Attachment;
import uz.pdp.task1_lesson2_modul2.entity.AttachmentContent;
import uz.pdp.task1_lesson2_modul2.repository.AttachmentContentRepository;
import uz.pdp.task1_lesson2_modul2.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @PostMapping
    public ResponseEntity<?> uploadToDb(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String contentType = file.getContentType();

            Attachment attachment = new Attachment();
            attachment.setContentType(contentType);
            attachment.setFileOriginalName(originalFilename);
            attachment.setSize(size);
            Attachment savedAttachment = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setMainContent(file.getBytes());
            attachmentContent.setAttachment(savedAttachment);
            attachmentContentRepository.save(attachmentContent);
            return ResponseEntity.status(201).body(savedAttachment.getId() + "-id lik fayl muvaffaqqiyatli saqlandi !");
        }
        return ResponseEntity.status(409).body("Error while adding !");
    }

    @GetMapping("/{id}")
    public void get(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();



            Optional<AttachmentContent> optionalContent = attachmentContentRepository.findByAttachmentId(id);
            if (optionalContent.isPresent()) {
                AttachmentContent attachmentContent = optionalContent.get();

                response.setHeader("Content-Disposition",
                        "attachment; filename=\"" + attachment.getFileOriginalName() + "\"");
                response.setContentType(attachment.getContentType());
                FileCopyUtils.copy(attachmentContent.getMainContent(), response.getOutputStream());
            }
        }
    }
}
