import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MyChangeFrame extends JFrame {

    FullForm fullForm = new FullForm();
    SimpleForm simpleForm = new SimpleForm();

    {
        setContentPane(fullForm);
        setMinimumSize(new Dimension(600, 400));
        fullForm.addApplyPerson(e -> fullSwitch());
        simpleForm.addApplyPerson(e -> simpleSwitch());
    }

    protected void fullSwitch() {
        Person person = fullForm.getPerson();
        if (person.getName().equals("") || person.getSurname().equals("")) {
            JOptionPane.showMessageDialog(fullForm, "field is null", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        simpleForm.setPerson(person);
        setContentPanel(simpleForm);
    }

    protected void simpleSwitch() {
        Person person = simpleForm.getPerson();
        if (Objects.nonNull(person)) {
            fullForm.setPerson(person);
            setContentPanel(fullForm);
        } else {
            return;
        }
    }

    protected void setContentPanel(Container container) {
        setContentPane(container);
        getContentPane().revalidate();
    }
}
