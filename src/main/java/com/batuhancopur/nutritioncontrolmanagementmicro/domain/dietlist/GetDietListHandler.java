package com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.VoidCommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.command.GetDietListCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.DietList;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.Meal;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.port.DietListPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.port.PatientInfoPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
@RequiredArgsConstructor
public class GetDietListHandler implements VoidCommandHandler<GetDietListCommand> {

    private final DietListPort dietListPort;
    private final PatientInfoPort patientInfoPort;

    @Override
    public void handle(GetDietListCommand command) throws DataNotFoundException, IOException {
        DietList dietList = dietListPort.getDietList(command.getPatientId(), command.getCreatedDate());
        Patient patient = patientInfoPort.getPatient(command.getPatientId());

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, command.getResponse().getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph title = new Paragraph(patient.getName()+" "+patient.getSurname(), fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(" "));

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        for (Meal meal : dietList.getMeals()) {
            Paragraph mealNameAndTime = new Paragraph(meal.getName()+" - "+meal.getTime(), fontParagraph);
            title.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(mealNameAndTime);
            for (String food : meal.getFoods()) {
                Paragraph foodName = new Paragraph(food, fontParagraph);
                foodName.setAlignment(Paragraph.ALIGN_LEFT);
                document.add(foodName);
            }
            document.add(new Paragraph(" "));
        }

        document.close();

    }
}
