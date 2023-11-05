package command;

public class RecommendCommand extends SpecialCommand implements Command{
    Integer idUser;
    String type;
    public RecommendCommand (Integer id, String type){
        super(id, type);
    }
    @Override
    public void execute() {
        specialExec(1);
   }
   public void undo(){};
}