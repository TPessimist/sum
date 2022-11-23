package uia.utils.dao;


public class MultiCmd {

  public Function<ExecuteContext, ExecuteContext> cmd;

  public MultiCmd() {

  }

  public static MultiCmd all(MultiCmd cmd1, MultiCmd cmd2) {
    return cmd1.andThen(cmd2.cmd);
  }

  public void execute(ExecuteContext ctx) throws Exception {
    this.cmd.apply(ctx);
  }

  public MultiCmd andThen(Function<ExecuteContext, ExecuteContext> f) {
    if (this.cmd == null) {
      this.cmd = f;
    } else {
      this.cmd = this.cmd.andThen(f);
    }
    return this;
  }

}
