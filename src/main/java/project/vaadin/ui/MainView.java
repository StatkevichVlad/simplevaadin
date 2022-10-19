package project.vaadin.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.beans.factory.annotation.Autowired;
import project.vaadin.backend.model.entity.UserEntity;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import project.vaadin.backend.service.impl.UserServiceImpl;


@Route("")
public class MainView extends VerticalLayout {
    @Autowired
    private UserServiceImpl userServiceImpl;


    Grid<UserEntity> grid = new Grid<>(UserEntity.class);
     TextField filterTextByName = new TextField();
     TextField filterTextByPhone = new TextField();

    TextField filterTextByAddress = new TextField();


    public MainView(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
        addClassName("list-view");
        setSizeFull();

        Button buttonRegistration = new Button("Add User");
        buttonRegistration.addClickListener(event -> UI.getCurrent().navigate("registration"));

        updateList();
        configureFilter();
        add(filterTextByName,filterTextByPhone,filterTextByAddress,buttonRegistration,grid);

    }

    private  void updateList(){
        grid.setItems(userServiceImpl.findAll());
    }
    private void updateListByName(){
        grid.setItems(userServiceImpl.findByName(filterTextByName.getValue()));
    }
    private void updateListByPhone(){
        grid.setItems(userServiceImpl.findAllByPhone(filterTextByPhone.getValue()));
    }

    private void updateListByAddress(){
        grid.setItems(userServiceImpl.findAllByAddress(filterTextByAddress.getValue()));
    }

    private void configureFilter(){
        userServiceImpl.findAll();

         filterTextByName.setPlaceholder("Filter by name");
         filterTextByName.setClearButtonVisible(true);
         filterTextByName.setValueChangeMode(ValueChangeMode.LAZY);
         filterTextByName.addValueChangeListener(e -> updateListByName() );

         filterTextByPhone.setPlaceholder("Filter by phone");
         filterTextByPhone.setClearButtonVisible(true);
         filterTextByPhone.setValueChangeMode(ValueChangeMode.LAZY);
         filterTextByPhone.addValueChangeListener(e -> updateListByPhone());

        filterTextByAddress.setPlaceholder("Filter by address");
        filterTextByAddress.setClearButtonVisible(true);
        filterTextByAddress.setValueChangeMode(ValueChangeMode.LAZY);
        filterTextByAddress.addValueChangeListener(e -> updateListByAddress());

    }
}
