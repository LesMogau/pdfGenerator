package com.example.pdfGenerator.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PDFGeneratorService {

    //creating the pdf document
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream()); //basically input the document name and write to
        // the output stream of the response....through lowargie

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(20);

        //writing to the file
        Paragraph paragraph = new Paragraph("My first pdf Hopefully",fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(14);

        Paragraph paragraph2 = new Paragraph("The first paragraph start here if this works next step is intergrating this with a database and making useful text",fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph3 = new Paragraph("The second paragraph start here if this works next step is intergrating this with a database and making useful text",fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        //referencing the paragraphs and adding to the actual focument
        document.add(paragraph);
        document.add(paragraph2);
        document.add(paragraph3);
        document.close();

    }

}
