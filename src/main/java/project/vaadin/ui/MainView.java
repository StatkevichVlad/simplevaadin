package project.vaadin.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.beans.factory.annotation.Autowired;
import project.vaadin.backend.entity.UserEntity;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import project.vaadin.backend.service.UserService;


@Route("")
public class MainView extends VerticalLayout {
    @Autowired
    private UserService userService;


    Grid<UserEntity> grid = new Grid<>(UserEntity.class);
     TextField filterTextByName = new TextField();
     TextField filterTextByPhone = new TextField();

    TextField filterTextByAddress = new TextField();


    public MainView(UserService userService){
        this.userService = userService;
        addClassName("list-view");
        setSizeFull();

        Button buttonRegistration = new Button("Add User");
        buttonRegistration.addClickListener(event -> UI.getCurrent().navigate("registration"));

        updateList();
        configureFilter();
        add(filterTextByName,filterTextByPhone,filterTextByAddress,buttonRegistration,grid);

    }

    private  void updateList(){
        grid.setItems(userService.findAll());
    }
    private void updateListByName(){
        grid.setItems(userService.findAll(filterTextByName.getValue()));
    }
    private void updateListByPhone(){
        grid.setItems(userService.findAllByPhone(filterTextByPhone.getValue()));
    }

    private void updateListByAddress(){
        grid.setItems(userService.findAllByAddress(filterTextByAddress.getValue()));
    }

    private void configureFilter(){
        userService.findAll();

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
