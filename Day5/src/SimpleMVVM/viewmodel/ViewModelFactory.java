package SimpleMVVM.viewmodel;

import SimpleMVVM.model.ModelFactory;
import SimpleMVVM.viewmodel.TimestampViewModel;

public class ViewModelFactory {

    private TimestampViewModel timestampViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        timestampViewModel = new TimestampViewModel(modelFactory.getDataModel());
    }

    public TimestampViewModel getTimestampViewModel() {
        return timestampViewModel;
    }
}
