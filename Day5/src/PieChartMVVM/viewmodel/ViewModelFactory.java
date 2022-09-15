package PieChartMVVM.viewmodel;

import PieChartMVVM.model.ModelFactory;
import PieChartMVVM.viewmodel.piechart.PieChartViewModel;

public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }
}
