 
class GameEvent {
  protected int type;

  GameEvent(int type) {
    this.type = type;
  }

  public int getType() { return type; }

  public static final int GE_ADD_ENTITY = 0;
}

class AddEntityEvent extends GameEvent {
  private Entity entity;
  public AddEntityEvent(Entity entity) {
    super(GameEvent.GE_ADD_ENTITY);
    this.entity = entity;
  }
  public Entity getEntity() { return entity; }
}

static class GameEventManager {
  private ArrayList<GameEvent> events;
  private ArrayList<GameEventListener> listeners;
  static GameEventManager instance=null;

  public static GameEventManager getInstance() { 
    if( instance != null ) {
      return instance; 
    } else {
      instance = new GameEventManager();
      return instance;
    }
  }

  private GameEventManager() {
    events = new ArrayList<GameEvent>();
    listeners = new ArrayList<GameEventListener>();
  }

  public void addListener(GameEventListener listener) {
    listeners.add(listener);
  }

  public void addEvent(GameEvent event) {
    events.add(event);
  }

  public void tick() {
    while(! events.isEmpty()) {
      GameEvent event = events.remove(0);
      for(GameEventListener listener : listeners) {
        listener.handleEvent(event);
      }
    }
  }
}

abstract class GameEventListener {
  public abstract void handleEvent(GameEvent event);
}

class GameView extends GameEventListener {
  protected ArrayList<Entity> entities;
  int blockSize;

  public GameView() {
    entities = new ArrayList<Entity>();
    blockSize = 10;
  }

  public void init() {
  }

  void drawBlock(int x, int y) {
    rect(x*blockSize, y*blockSize, blockSize, blockSize);
  }

  public void draw() {
    //fill(255);
    //stroke(255);

    for(Entity entity : entities) {
      switch(entity.getType()) {
        case Entity.ROOM_TYPE:
          Room room = (Room)entity;
          //Draw top and bottom parts of rect border around room
          for(int i = 0 ; i < room.getWt() ; i++) {
            drawBlock(room.getX() + i, room.getY()); //top
            drawBlock(room.getX() + i, room.getY()+room.getHt()-1); //bottom
          }
          //Draw left and right hand parts of rect border around room
          for(int i = 0 ; i < room.getHt() ; i++) {
            drawBlock(room.getX(), room.getY() + i); //left
            drawBlock(room.getX() + room.getWt()-1, room.getY() + i); //right
          }

      }
    }
  }

  public void handleEvent(GameEvent event) {
    if(event.getType() == GameEvent.GE_ADD_ENTITY) {
      entities.add(((AddEntityEvent)event).getEntity());
    }
  } 
}

class Entity {
  protected int type;
  protected int x, y;

  public Entity(int type, int x, int y) {
    this.type = type;
    this.x = x;
    this.y = y;
  }

  public static final int ROOM_TYPE = 0;
  public static final int HALL_TYPE = 1;

  public int getType() { return type; }
  public int getX() { return x; }
  public int getY() { return y; }
}

class Room extends Entity {
  private int wt, ht; //Width and height
  public Room(int x, int y, int wt, int ht) {
    super(Entity.ROOM_TYPE, x, y);
    this.wt = wt;
    this.ht = ht;
  }
  public int getWt() { return wt; }
  public int getHt() { return ht; }
}

/*
class Hallway extends Entity {
  public Hallway(int x, int y) {
    super(x, y);
  }
}
*/

class GameLogic extends GameEventListener{
  protected ArrayList entities;

  public GameLogic() {
    entities = new ArrayList();
  }

  //Factory method
  public void createRoom(int x, int y, int w, int h) {
    Room room = new Room(x,y,w,h);
    entities.add(room);
    GameEventManager.getInstance().addEvent(new AddEntityEvent(room));
  }

  public void generateGrid(int roomLength, int max) {
    for(int i = 0 ; i < max ; i++) {
      for(int j = 0 ; j < max ; j++) {
        if((i != max/2)){
          createRoom(i*roomLength,j*roomLength,roomLength,roomLength);
        }
      }
    }
  }

  public void init() {
    generateGrid(7,7);
  }

  public void update() {
  }
  
  public void handleEvent(GameEvent event) {
  }
}

class App {
  final int SCREEN_WIDTH = 640;
  final int SCREEN_HEIGHT = 480;

  private GameLogic gameLogic;
  private GameView gameView;

  public App() {
    size(SCREEN_WIDTH, SCREEN_HEIGHT);  
    gameLogic = new GameLogic();
    GameEventManager.getInstance().addListener(gameLogic);
    gameView = new GameView();
    GameEventManager.getInstance().addListener(gameView);
    //this.grid = new Grid(SCREEN_WIDTH, SCREEN_HEIGHT, BLOCK_HALFSIZE);

    //grid.setBlockTypeRectangle(0, 0, 1, SCREEN_WIDTH/BLOCK_HALFSIZE, SCREEN_HEIGHT/BLOCK_HALFSIZE);
  } 

  public void init() {
    gameLogic.init();
    gameView.init();
  }

  public void draw() {
//    this.grid.draw();

    gameLogic.update();

    gameView.draw();
    
    GameEventManager.getInstance().tick();
  }
}

App app;

void setup() {
  app = new App();
  app.init();
}

void draw() {
  app.draw();
}
