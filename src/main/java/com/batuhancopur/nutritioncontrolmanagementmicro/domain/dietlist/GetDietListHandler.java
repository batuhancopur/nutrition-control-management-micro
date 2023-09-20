package com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.VoidCommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.command.GetDietListCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.DietList;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.Meal;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.port.DietListPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.port.PatientInfoPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class GetDietListHandler implements VoidCommandHandler<GetDietListCommand> {

    private final DietListPort dietListPort;
    private final PatientInfoPort patientInfoPort;

    /**
     * @apiNote Get diet list of patient
     * @param command
     * @throws DataNotFoundException
     * @throws IOException
     */
    @Override
    public void handle(GetDietListCommand command) throws DataNotFoundException, IOException {
        Document document = new Document(PageSize.A4);


        try {
        DietList dietList = dietListPort.getDietList(command.getPatientId(), command.getCreatedDate());
        Patient patient = patientInfoPort.getPatient(command.getPatientId());

        Path path = Paths.get(ClassLoader.getSystemResource("img/NG_LOGO.png").toURI());

        PdfWriter.getInstance(document, command.getResponse().getOutputStream());

        document.open();
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        img.scaleAbsolute(100,100);
        img.setAlignment(Image.ALIGN_CENTER);
        document.add(img);

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph title = new Paragraph(patient.getName()+" "+patient.getSurname(), fontTitle);
        title.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(title);
        document.add(new Paragraph(" "));

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        for (Meal meal : dietList.getMeals()) {
            Paragraph mealNameAndTime = new Paragraph(meal.getName()+" - "+meal.getTime(), fontParagraph);
            title.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(mealNameAndTime);
            document.add(new LineSeparator(2, 100, null, 10, -5));

            for (String food : meal.getFoods()) {
                Paragraph foodName = new Paragraph(food, fontParagraph);
                foodName.setAlignment(Paragraph.ALIGN_LEFT);
                document.add(foodName);
            }
            document.add(new Paragraph(" "));
        }
        document.addCreationDate();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } finally {
            document.close();
        }
    }
}
