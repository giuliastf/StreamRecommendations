package command;

public class SurpriseCommand extends SpecialCommand implements Command  {
    Integer idUser;
    String type;

    public SurpriseCommand(Integer id, String type) {
        super(id, type);
    }
    public void execute() {
        specialExec(0);
    }

    public void undo(){;}
}