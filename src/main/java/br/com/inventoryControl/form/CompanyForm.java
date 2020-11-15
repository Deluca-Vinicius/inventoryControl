package br.com.inventoryControl.form;

import br.com.inventoryControl.entities.Company;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CompanyForm {

    @NotNull
    String name;



    public Company creationConverter() {
        return new Company(name);
    }

}
