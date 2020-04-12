import com.codingame.gameengine.runner.MultiplayerGameRunner;

public class Main {

    public static void main(String[] args) {
        // read cli args
        Options opts = new Options().read(args);
        String cli1 = opts.commandLine1;
        String cli2 = opts.commandLine2;
        String cli3 = opts.commandLine3;

        MultiplayerGameRunner gameRunner = new MultiplayerGameRunner();
        // Set league, remove before push.
        gameRunner.setLeagueLevel(3);
        gameRunner.setSeed(Long.parseLong(cli3));
        // add player 1
        if (null != cli1) {
            gameRunner.addAgent(cli1);
        } else {
            gameRunner.addAgent(DummyPlayer.class);
        }
        // add player 2
        if (null != cli2) {
            gameRunner.addAgent(cli2);
        } else {
            gameRunner.addAgent(DummyPlayer.class);
        }
        //gameRunner.addAgent(Player2.class);

        //gameRunner.addAgent("python3 bot.py");
        //gameRunner.addAgent("python3 bot.py");
        //gameRunner.addAgent("java -cp target/test-classes/ Player"); //-agentlib:jdwp=transport=dt_socket,server=y,address=8681,suspend=y,quiet=y
        //gameRunner.addAgent("java -cp target/test-classes/ Player2"); //-agentlib:jdwp=transport=dt_socket,server=y,address=8682,suspend=y,quiet=y

        // gameRunner.addCommandLinePlayer("python src/main/resources/ai/ai.py");

        if (opts.commandLine4.equals("simulate")) {
          gameRunner.simulate();
        } else {
          gameRunner.start();
        }
    }
}

class Options {
    public String commandLine1 = null;
    public String commandLine2 = null;
    public String commandLine3 = null;
    public String commandLine4 = null;

    public Options read(String[] args) {
      this.commandLine1 = args[0];
      this.commandLine2 = args[1];
      this.commandLine3 = args[2];
      this.commandLine4 = args[3];
      return this;
    }
}
