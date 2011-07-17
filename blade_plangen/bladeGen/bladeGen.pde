 
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

class Triangle {
  float x1,y1,z1;
  float x2,y2,z2;
  float x3,y3,z3;

  public Triangle(float x1, float y1, float z1,
      float x2, float y2, float z2,
      float x3, float y3, float z3
      ) {
    this.x1 = x1;
    this.y1 = y1;
    this.z1 = z1;

    this.x2 = x2;
    this.y2 = y2;
    this.z2 = z2;

    this.x3 = x3;
    this.y3 = y3;
    this.z3 = z3;
  }

  float getX1() { return x1; }
  float getY1() { return y1; }
  float getZ1() { return z1; }

  float getX2() { return x2; }
  float getY2() { return y2; }
  float getZ2() { return z2; }

  float getX3() { return x3; }
  float getY3() { return y3; }
  float getZ3() { return z3; }
}

class Point2 {
  float x, y;
  Point2(float x, float y) {
    this.x = x;
    this.y = y;
  }
  public float getX() { return x; }
  public float getY() { return y; }
}

abstract class Entity {
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

  public abstract ArrayList<Triangle> getTriangles(float lowY, float highY, int camx, int camy);

  public abstract ArrayList<Point2> getUVCoords();

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

  private ArrayList<Triangle> extrudeLineSegTo3D(int x1, int z1, int x2, int z2, float lowY, float highY) {
    //Two triangles : 
    // (x1,z1)   (x2,z2)
    // * ------- * highY
    // | \       |
    // |  \      |
    // |   \     |
    // |    \    |
    // |     \   |
    // |      \  |
    // |       \ |
    // * ------- * lowY
    ArrayList<Triangle> res = new ArrayList<Triangle>();
//    res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x1,lowY,z1));
//    res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x2,highY,z2));

    res.add(new Triangle(x1,highY,z1, x1,lowY, z1, x2,lowY,z2));
    res.add(new Triangle(x1,highY,z1, x2, highY, z2, x2,lowY,z2));
    return res; 
  }

  public ArrayList<Triangle> getTriangles(float lowY, float highY, int camx, int camy) {
    ArrayList<Triangle> res = new ArrayList<Triangle>();

    //TODO:Offset room coords by camera pos
    res.addAll(extrudeLineSegTo3D(x,y, x+wt,y, lowY, highY));
    res.addAll(extrudeLineSegTo3D(x,y, x,y+ht, lowY, highY));
    res.addAll(extrudeLineSegTo3D(x+wt,y, x+wt,y+ht, lowY, highY));
    res.addAll(extrudeLineSegTo3D(x,y+ht, x+wt,y+ht, lowY, highY));

    return res;
  }

  public ArrayList<Point2> getUVCoords() {
    ArrayList<Point2> res = new ArrayList<Point2>();
    float amount = 6.0;
    // TODO:Verify this is correct.
    res.add(new Point2(0,amount));
    res.add(new Point2(0,0));
    res.add(new Point2(amount,0));

    res.add(new Point2(0,amount));
    res.add(new Point2(amount,amount));
    res.add(new Point2(amount,0));

    res.add(new Point2(0,amount));
    res.add(new Point2(0,0));
    res.add(new Point2(amount,0));

    res.add(new Point2(0,amount));
    res.add(new Point2(amount,amount));
    res.add(new Point2(amount,0));

    res.add(new Point2(0,amount));
    res.add(new Point2(0,0));
    res.add(new Point2(amount,0));

    res.add(new Point2(0,amount));
    res.add(new Point2(amount,amount));
    res.add(new Point2(amount,0));

    res.add(new Point2(0,amount));
    res.add(new Point2(0,0));
    res.add(new Point2(amount,0));

    res.add(new Point2(0,amount));
    res.add(new Point2(amount,amount));
    res.add(new Point2(amount,0));

    return res;
  }
}

/*
class Hallway extends Entity {
  public Hallway(int x, int y) {
    super(x, y);
  }
}
*/

//TODO:Make into an entity? Don't see the point...
class Plane {
  int xMin, zMin, xMax, zMax, y;

  public Plane(int xMin, int zMin, int xMax, int zMax, int y) {
    this.xMin = xMin;
    this.zMin = zMin;
    this.xMax = xMax;
    this.zMax = zMax;
    this.y = y;
  }

  public ArrayList<Triangle> getTriangles()
  {
    //Two triangles : 
    //           (xMax, y, zMax)
    // * ------- * 
    // | \       |
    // |  \      |
    // |   \     |
    // |    \    |
    // |     \   |
    // |      \  |
    // |       \ |
    // * ------- *
    //(xMin, y, zMin)
    ArrayList<Triangle> res = new ArrayList<Triangle>();
//    res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x1,lowY,z1));
//    res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x2,highY,z2));

    res.add(new Triangle(xMin,y,zMax, xMin,y,zMin, xMax,y,zMin));
    res.add(new Triangle(xMin,y,zMax, xMax,y,zMax, xMax,y,zMin));

    return res;
  }

  public ArrayList<Point2> getUVCoords()
  {
    ArrayList<Point2> res = new ArrayList<Point2>();
    float amount = 6.0;
    res.add(new Point2(0,amount));
    res.add(new Point2(0,0));
    res.add(new Point2(amount,0));

    res.add(new Point2(0,amount));
    res.add(new Point2(amount,amount));
    res.add(new Point2(amount,0));

    return res;
  }

  public String toString() {
    String resultStr = "";
    ArrayList<Triangle> triangles = getTriangles();
    ArrayList<Point2> uvCoords = getUVCoords();
    int i = 0;
    for(Triangle tri : triangles) {
      resultStr += Float.toString(tri.getX1()) + " " +
        Float.toString(tri.getY1()) + " " +
        Float.toString(tri.getZ1()) + " " +
        Float.toString(uvCoords.get(i).getX()) + " " +
        Float.toString(uvCoords.get(i++).getY()) + "\n" +
        Float.toString(tri.getX2()) + " " +
        Float.toString(tri.getY2()) + " " +
        Float.toString(tri.getZ2()) + " " +
        Float.toString(uvCoords.get(i).getX()) + " " + 
        Float.toString(uvCoords.get(i++).getY()) + "\n" +
        Float.toString(tri.getX3()) + " " +
        Float.toString(tri.getY3()) + " " +
        Float.toString(tri.getZ3()) + " " +
        Float.toString(uvCoords.get(i).getX()) + " " +
        Float.toString(uvCoords.get(i++).getY()) + "\n";
    }
    return resultStr;
  }
}

class GameLogic extends GameEventListener{
  protected ArrayList<Entity> entities;

  public GameLogic() {
    entities = new ArrayList<Entity>();
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
        if((i % 2 != 1) && (j % 2 != 1)){
          createRoom(i*roomLength,j*roomLength,roomLength,roomLength);
        }
      }
    }
  }

/*
  public void generateOffice00(int roomWidth, int roomHeight, int max) {
	//Problem: Corner rooms have no hallway access
    for(int i = 0 ; i < max ; i++) {
      for(int j = 0 ; j < max ; j++) {
        if( ((i % 2 == 1) && (j!=0) && (j!=(max-1))) //Left and Right sides
			|| ((j==1) && (i!=0) && (i!=max-1)) //Left side hallway
			|| ((j==max-2) && (i!=0) && (i!=max-1)) //Right side hallway
			){
			continue;
		}
          createRoom(i*roomWidth,j*roomHeight,roomWidth,roomHeight);
      }
    }
  }
*/

  public void generateOffice01(int roomWidth, int roomHeight, int max) {
	  //Problem: Corner rooms have no hallway access
	  for(int i = 0 ; i < max ; i++) {
		  for(int j = 0 ; j < max ; j++) {
			  if( ((i % 2 == 1) && (j!=0) && (j!=(max-1))) //Left and Right sides
					  || ((j==1) && (i!=0) && (i!=max-1)) //Left side hallway
					  || ((j==max-2) && (i!=0) && (i!=max-1)) //Right side hallway
					  || ((i==1 || i==max-1) && (j==0 || j==max-1)) //No 2nd one
				){
				  continue;
			  }

			  if((j==0 || j==max-1) && (i==0 || i==max-2)) {
				  //Make room which is of twice the width
				  createRoom(i*roomWidth,j*roomHeight,roomWidth*2,roomHeight);
			  } else {
				  createRoom(i*roomWidth,j*roomHeight,roomWidth,roomHeight);
			  }
		  }
	  }
  }

  public String getEntitiesAsStr(int camx, int camy, ArrayList<Entity> entities) {
    String resultStr = "";
    //Cycle through entities and output their vertices
    for(Entity e : entities) {
      ArrayList<Triangle> triangles = e.getTriangles(0,2, camx,camy);
      ArrayList<Point2> uvCoords = e.getUVCoords();
      int i = 0;
      for(Triangle tri : triangles) {
        resultStr += Float.toString(tri.getX1()) + " " +
          Float.toString(tri.getY1()) + " " +
          Float.toString(tri.getZ1()) + " " +
          Float.toString(uvCoords.get(i).getX()) + " " +
          Float.toString(uvCoords.get(i++).getY()) + "\n" +
          Float.toString(tri.getX2()) + " " +
          Float.toString(tri.getY2()) + " " +
          Float.toString(tri.getZ2()) + " " +
          Float.toString(uvCoords.get(i).getX()) + " " + 
          Float.toString(uvCoords.get(i++).getY()) + "\n" +
          Float.toString(tri.getX3()) + " " +
          Float.toString(tri.getY3()) + " " +
          Float.toString(tri.getZ3()) + " " +
          Float.toString(uvCoords.get(i).getX()) + " " +
          Float.toString(uvCoords.get(i++).getY()) + "\n";
      }
    }
    return resultStr;
  }

  public void init() {
//    generateGrid(7,7);
    generateOffice01(3,4,7);

    String entityStr = getEntitiesAsStr(10,10,entities);
    System.out.println("Entities:\n---\n " + entityStr + "\n---");

    Plane ceiling = new Plane(0,0, 1000,1000, 2);
    System.out.println("Ceiling:\n---\n" + ceiling.toString() + "\n---");

    Plane floor = new Plane(0,0, 1000,1000, 0);
    System.out.println("Floor:\n---\n" + floor.toString() + "\n---");
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
