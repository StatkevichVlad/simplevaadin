package project.vaadin.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import project.vaadin.backend.component.mapper.UserMapper;
import project.vaadin.backend.component.mapper.impl.UserMapperImpl;
import project.vaadin.backend.model.dto.UserDto;
import project.vaadin.backend.service.impl.UserServiceImpl;

@Route("registration")
public class RegistrationView extends VerticalLayout {

    @Autowired
    private UserServiceImpl userServiceImpl;
    private TextField textFieldName;
    private TextField textFieldPhone;
    private TextField textFieldAddress;
    private Text textFieldRegistrationAnswer;

    private UserDto userDto = new UserDto();

    public RegistrationView(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;

         textFieldName = new TextField();
         textFieldPhone = new TextField();
         textFieldAddress = new TextField();
         textFieldRegistrationAnswer = new Text("");


        textFieldName.setPlaceholder("Name");
        textFieldPhone.setPlaceholder("Phone");
        textFieldAddress.setPlaceholder("Address");

        Button buttonOk = new Button("Ok", event -> addNewUser(
                textFieldName.getValue()
                ,Integer.parseInt(textFieldPhone.getValue())
                ,textFieldAddress.getValue()
        ));
        add(textFieldName,textFieldPhone,textFieldAddress,buttonOk,textFieldRegistrationAnswer);
    }

    private void addNewUser(String textFieldName, Integer textFieldPhone , String textFieldAddress){
        UserMapper userMapper = new UserMapperImpl();
        userDto.setName(textFieldName);
        userDto.setPhone(textFieldPhone);
        userDto.setAddress(textFieldAddress);

        userServiceImpl.addUser(userMapper.userDtoToUserEntity(userDto));

        textFieldRegistrationAnswer.setText("Registration success");

    }
}
