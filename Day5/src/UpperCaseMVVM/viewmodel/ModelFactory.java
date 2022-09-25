package UpperCaseMVVM.viewmodel;

import UpperCaseMVVM.model.TextConverter;
import UpperCaseMVVM.model.TextConverterModel;

public class ModelFactory {

    private TextConverter textConverter;

    public TextConverter getTextConverter() {
        if(textConverter == null)
            textConverter = new TextConverterModel();
        return textConverter;
    }
}


