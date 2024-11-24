package com.example.gestionnominas;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.net.URL;
import java.util.ResourceBundle;

public class NominaController implements Initializable {

    @FXML
    private TableView<Empleado> TablaView;

    @FXML
    private Button bLimpiar;

    @FXML
    private Button bRegistrar;

    @FXML
    private ComboBox<String> cBanco;

    @FXML
    private ComboBox<String> cCuenta;

    @FXML
    private TableColumn<Empleado, String> coApellido;

    @FXML
    private TableColumn<Empleado, String> coArea;

    @FXML
    private TableColumn<Empleado, String> coBanco;

    @FXML
    private TableColumn<Empleado, String> coCargo;

    @FXML
    private TableColumn<Empleado, String> coCedula;

    @FXML
    private TableColumn<Empleado, String> coNombre;

    @FXML
    private TableColumn<Empleado, Double> coSalarioBruto;

    @FXML
    private TableColumn<Empleado, Double> coSalarioNeto;

    @FXML
    private TextField tNombre;

    @FXML
    private TextField tApellido;

    @FXML
    private TextField tCargo;

    @FXML
    private TextField tSalario;

    @FXML
    private TextField tCedula;

    @FXML
    private TextField tArea;

    @FXML
    private TextField tCuenta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cBanco.getItems().addAll("BanReservas", "BHD", "Popular");
        cCuenta.getItems().addAll("Cuenta de Ahorros", "Cuenta Corriente");

        coNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        coApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        coCargo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCargo()));
        coArea.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArea()));
        coCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        coBanco.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBanco()));
        coSalarioBruto.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getSalarioBruto()).asObject());
        coSalarioNeto.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getSalarioNeto()).asObject());

        setup();
    }

    @FXML
    private void limpiarCampos() {
        tNombre.clear();
        tApellido.clear();
        tCargo.clear();
        tSalario.clear();
        tCedula.clear();
        tArea.clear();
        tCuenta.clear();

        cBanco.setValue(null);
        cCuenta.setValue(null);
    }

    @FXML
    private void registrarEmpleado() {
        String nombre = tNombre.getText();
        String apellido = tApellido.getText();
        String cargo = tCargo.getText();
        double salario = Double.parseDouble(tSalario.getText());
        String cedula = tCedula.getText();
        String area = tArea.getText();
        String banco = cBanco.getValue();

        Empleado empleado = new Empleado(nombre, apellido, cargo, salario, cedula, area, banco);

        TablaView.getItems().add(empleado);

        ExportarNomina.exportar(empleado, banco);


        limpiarCampos();
    }

    @FXML
    private void setup() {
        bLimpiar.setOnAction(event -> limpiarCampos());
        bRegistrar.setOnAction(event -> registrarEmpleado());
    }
}
