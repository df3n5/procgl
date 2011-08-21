 
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

  void drawBlock(float x, float y) {
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

class Vector3 {
  protected float x,y,z;

  public Vector3() {
    x = 0.0f;
    y = 0.0f;
    z = 0.0f;
  }

  public Vector3(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public float getX() { return x; }
  public float getY() { return y; }
  public float getZ() { return z; }

  public Vector3 crossProduct(Vector3 other) { 
    float x = (this.y * other.getZ()) - (this.z * other.getY());
    float y = (this.z * other.getX()) - (this.x * other.getZ());
    float z = (this.x * other.getY()) - (this.y * other.getX());
    return new Vector3(x,y,z);
  }

  public Vector3 subtract(Vector3 other) { 
    float x = this.x - other.getX();
    float y = this.y - other.getY();
    float z = this.z - other.getZ();
    return new Vector3(x,y,z);
  }

  public float magnitude() {
    return sqrt(x*x + y*y + z*z);
  }

  public Vector3 normalize() throws Exception{
    float mag = magnitude();
    if(mag > 0)
    {
      float invMag = 1.0f/mag;
      return new Vector3(invMag*x, invMag*y, invMag*z);
    } else {
      throw new Exception("Vector cannot have a mag 0 and have a normal");
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

  public float dist(Point2 other) {
    return (float)Math.sqrt((other.getX()-x) * (other.getX()-x) + 
        (other.getY()-y) * (other.getY()-y));
  }
}

class Cuboid {
  float x;
  float y;
  float z;
  float depth;
  float ht;
  float len;

  Cuboid(float x, float y, float z, 
      float depth, float ht, float len) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.depth = depth;
    this.ht = ht;
    this.len = len;
  }

  public float getX() { return x; }
  public float getY() { return y; }
  public float getZ() { return z; }
  public float getDepth() { return depth; }
  public float getHeight() { return ht; }
  public float getLength() { return len; }
}

abstract class Entity {
  protected int type;
  protected float x, y;
  protected ArrayList<Triangle> triangles;
  protected ArrayList<Point2> texCoords;
  protected ArrayList<Vector3> normals;

  public Entity(int type, float x, float y) {
    this.type = type;
    this.x = x;
    this.y = y;
  }

  public static final int ROOM_TYPE = 0;
  public static final int PILLAR_TYPE = 1;
  public static final int PLANE_TYPE = 2;

  public int getType() { return type; }
  public float getX() { return x; }
  public float getY() { return y; }

  protected abstract void generateTriangles();

  protected abstract void generateTexCoords();

  //Only to be called by "toString()"
  protected void generateGeom() {
    generateTriangles();
    generateNormals();
    generateTexCoords();
  }

  //Only to be called by "toString()"
  protected String geomAsString() {
    String resultStr = "";
    int texCoordI = 0;
    int normalI = 0;
    for(Triangle tri : triangles) {
      resultStr += Float.toString(tri.getX1()) + " " +
        Float.toString(tri.getY1()) + " " +
        Float.toString(tri.getZ1()) + " " +
        Float.toString(normals.get(normalI).getX()) + " " +
        Float.toString(normals.get(normalI).getY()) + " " +
        Float.toString(normals.get(normalI++).getZ()) + " " +
        Float.toString(texCoords.get(texCoordI).getX()) + " " +
        Float.toString(texCoords.get(texCoordI++).getY()) + "\n" +
        Float.toString(tri.getX2()) + " " +
        Float.toString(tri.getY2()) + " " +
        Float.toString(tri.getZ2()) + " " +
        Float.toString(normals.get(normalI).getX()) + " " +
        Float.toString(normals.get(normalI).getY()) + " " +
        Float.toString(normals.get(normalI++).getZ()) + " " +
        Float.toString(texCoords.get(texCoordI).getX()) + " " + 
        Float.toString(texCoords.get(texCoordI++).getY()) + "\n" +
        Float.toString(tri.getX3()) + " " +
        Float.toString(tri.getY3()) + " " +
        Float.toString(tri.getZ3()) + " " +
        Float.toString(normals.get(normalI).getX()) + " " +
        Float.toString(normals.get(normalI).getY()) + " " +
        Float.toString(normals.get(normalI++).getZ()) + " " +
        Float.toString(texCoords.get(texCoordI).getX()) + " " +
        Float.toString(texCoords.get(texCoordI++).getY()) + "\n";
    }
    return resultStr;
  }    

  public String toString() {
    generateGeom();
    return geomAsString();
  }

  protected ArrayList<Triangle> extrudeLineSegTo3D(
      float x1, float z1, float x2, 
      float z2, float lowY, float highY) {
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

    res.add(new Triangle(x1,highY,z1, x1,lowY,z1, x2,lowY,z2));
    res.add(new Triangle(x1,highY,z1, x2,highY,z2, x2,lowY,z2));
    return res; 
  }

  public ArrayList<Triangle> getTrianglesFromSquare(float x1, float y1,float z1,
      float x2, float y2, float z2) {
    //Two triangles : 
    // (x1,y1,z1)   
    // * ------- *
    // | \       |
    // |  \      |
    // |   \     | Anticlockwise triangle vertex decl.
    // |    \    |
    // |     \   |
    // |      \  |
    // |       \ |
    // * ------- * (x2,y2,z2)
    ArrayList<Triangle> res = new ArrayList<Triangle>();

    res.add(new Triangle(x1,y1,z1, x1,y2, z1, x2,y2,z2));
    res.add(new Triangle(x1,y1,z1, x2, y1, z2, x2,y2,z2));
    return res;
  }

  public ArrayList<Triangle> getTrianglesFromSquareHor(float x1, float y1,float z1,
      float x2, float y2, float z2) {
    ArrayList<Triangle> res = new ArrayList<Triangle>();

    res.add(new Triangle(x1,y1,z1, x1,y1,z2, x2,y1,z2));
    res.add(new Triangle(x1,y1,z1, x2, y1, z1, x2,y1,z2));
    return res;
  }

  public ArrayList<Point2> getTexCoordsFromSquare(float x1, float y1,
      float x2, float y2) {
    //Two triangles : 
    // (x1,y1)   
    // *---------* (x2,y1)
    // | \       |
    // |  \      |
    // |   \     |
    // |    \    |
    // |     \   |
    // |      \  |
    // |       \ |
    // *---------* (x2,y2)
    ArrayList<Point2> res = new ArrayList<Point2>();

    res.add(new Point2(x1,y1));
    res.add(new Point2(x1,y2));
    res.add(new Point2(x2,y2));

    res.add(new Point2(x1,y1));
    res.add(new Point2(x2,y1));
    res.add(new Point2(x2,y2));

   return res;
  }

  //For plain wall (no windows)
  protected ArrayList<Point2> extrudeLineSegTo3DTexCoords(
      float x1, float z1,
      float x2, float z2,
      float lowY, float highY) {
    //Two triangles : 
    // (0.0, highY, 0.0)    (wt,highY)
    // * ------- * highY
    // | \       |
    // |  \      |
    // |   \     |
    // |    \    |
    // |     \   |
    // |      \  |
    // |       \ |
    // * ------- * lowY
    ArrayList<Point2> res = new ArrayList<Point2>();

    //Width is the length of the wall, which is distance between points in 2d
    float wt = (float)Math.sqrt( ((x2-x1)*(x2-x1)) + ((z2-z1)*(z2-z1)));

    res.addAll(getTexCoordsFromSquare(0.0f, highY, wt, lowY));
    return res; 
  }

  protected Vector3 generateNormalFromTri(Triangle tri) {
    // *k
    // | \ 
    // |  \   
    // |   \
    // |    \ 
    // ^b    \ 
    // |      \ 
    // |   a   \ 
    // *l-->----m*
    Vector3 k = new Vector3(tri.getX1(), tri.getY1(), tri.getZ1());
    Vector3 l = new Vector3(tri.getX2(), tri.getY2(), tri.getZ2());
    Vector3 m = new Vector3(tri.getX3(), tri.getY3(), tri.getZ3());

    Vector3 a = m.subtract(l);
    Vector3 b = k.subtract(l);

    Vector3 cross = a.crossProduct(b);

    try{
      Vector3 res = cross.normalize();
      return res;
    }catch(Exception e) {
      System.err.println("Cannot normalize vector, cross is : "
          + cross.getX() + "," 
          + cross.getY() + "," 
          + cross.getZ());

      System.err.println("Type is : " + this.type);

      System.err.println("Cannot normalize vector, a is : "
          + a.getX() + "," 
          + a.getY() + "," 
          + a.getZ());

      System.err.println("Cannot normalize vector, b is : "
          + b.getX() + "," 
          + b.getY() + "," 
          + b.getZ());

      System.err.println("Cannot normalize vector, k is : "
          + k.getX() + "," 
          + k.getY() + "," 
          + k.getZ());

      System.err.println("Cannot normalize vector, l is : "
          + l.getX() + "," 
          + l.getY() + "," 
          + l.getZ());

      System.err.println("Cannot normalize vector, m is : "
          + m.getX() + "," 
          + m.getY() + "," 
          + m.getZ());

      e.printStackTrace();
      return null;
    }
  }

  protected ArrayList<Vector3> generateNormalsFromTriangles() {
    ArrayList<Vector3> res = new ArrayList<Vector3>();
    for(Triangle tri : triangles) {
      Vector3 normal = generateNormalFromTri(tri);
      res.add(normal);
      res.add(normal);
      res.add(normal);
    }
    return res;
  }

  protected ArrayList<Triangle> getTrianglesFromCuboid(Cuboid cuboid) {
    ArrayList<Triangle> res = new ArrayList<Triangle>();

    //1
    res.addAll( getTrianglesFromSquare(
          cuboid.getX(), 
          cuboid.getY(), 
          cuboid.getZ(),
          cuboid.getX() + cuboid.getDepth(),
          cuboid.getY() + cuboid.getHeight(),
          cuboid.getZ() ));

    //2
    res.addAll( getTrianglesFromSquare(
          cuboid.getX() + cuboid.getDepth(),
          cuboid.getY(), 
          cuboid.getZ(),
          cuboid.getX() + cuboid.getDepth(),
          cuboid.getY() + cuboid.getHeight(),
          cuboid.getZ() + cuboid.getLength()));

    //3
    res.addAll( getTrianglesFromSquare(
          cuboid.getX() + cuboid.getDepth(),
          cuboid.getY(), 
          cuboid.getZ() + cuboid.getLength(),
          cuboid.getX(),
          cuboid.getY() + cuboid.getHeight(),
          cuboid.getZ() + cuboid.getLength()));

    //4
    res.addAll( getTrianglesFromSquare(
          cuboid.getX(),
          cuboid.getY(), 
          cuboid.getZ() + cuboid.getLength(),
          cuboid.getX(),
          cuboid.getY() + cuboid.getHeight(),
          cuboid.getZ()));

    //5
    res.addAll( getTrianglesFromSquareHor(
          cuboid.getX(),
          cuboid.getY() + cuboid.getHeight(), 
          cuboid.getZ(),
          cuboid.getX() + cuboid.getDepth(),
          cuboid.getY() + cuboid.getHeight(),
          cuboid.getZ() + cuboid.getLength()));

    //6
    res.addAll( getTrianglesFromSquareHor(
          cuboid.getX(),
          cuboid.getY(), 
          cuboid.getZ(),
          cuboid.getX() + cuboid.getDepth(),
          cuboid.getY(),
          cuboid.getZ() + cuboid.getLength()));

    return res;
  }

  protected ArrayList<Triangle> generateTrianglesFromCuboids(ArrayList<Cuboid> cuboids) {
    ArrayList<Triangle> res = new ArrayList<Triangle>();
    for(Cuboid cuboid : cuboids) {
      res.addAll(getTrianglesFromCuboid(cuboid));       
    }
    return res;
  }

  protected ArrayList<Point2> getTexCoordsFromCuboid(Cuboid cuboid) {
    ArrayList<Point2> res = new ArrayList<Point2>();
    float x1 = 0.0;
    float y1 = 0.0;
    float x2 = 1.0;
    float y2 = 1.0;

    for(int i = 0 ; i < 6 ; i++) {
      //Ignore windows
      res.add(new Point2(x1,y1));
      res.add(new Point2(x1,y2));
      res.add(new Point2(x2,y2));

      res.add(new Point2(x1,y1));
      res.add(new Point2(x2,y1));
      res.add(new Point2(x2,y2));
    }
    return res;
  }

  protected ArrayList<Point2> generateTexCoordsFromCuboids(ArrayList<Cuboid> cuboids) {
    ArrayList<Point2> res = new ArrayList<Point2>();
    for(Cuboid cuboid : cuboids) {
      res.addAll(getTexCoordsFromCuboid(cuboid));       
    }
    return res;
  }

  protected void generateNormals() {
    this.normals = generateNormalsFromTriangles();
  }
}

class Window{
  private int wallN;
  private Point2 startPoint;
  private Point2 windowSpan;

  public Window(int wallN, 
      Point2 startPoint, 
      Point2 windowSpan) {
    this.wallN = wallN;
    this.startPoint = startPoint;
    this.windowSpan = windowSpan;
  }
  
  public int getWallN() { return wallN; }
  public Point2 getStartPoint() { return startPoint; }
  public Point2 getWindowSpan() { return windowSpan; }

}

class Room extends Entity {
  protected int wt, ht; //Width and height
  protected float lowY, highY; //Y for floor and ceiling
  protected ArrayList<Window> windows; // = new int[0];

  public Room(int x, int y, int wt, int ht, float lowY, float highY) {
    super(Entity.ROOM_TYPE, x, y);
    this.wt = wt;
    this.ht = ht;
    this.lowY = lowY;
    this.highY = highY;
    windows = new ArrayList<Window>();
  }
  public int getWt() { return wt; }
  public int getHt() { return ht; }

  protected ArrayList<Triangle> extrudeWallFlat(int wallN, 
      float lowY, float highY) {
    switch(wallN) {
      case 0:
        return extrudeLineSegTo3D(x,y, x+wt,y, lowY, highY);
      case 1:
        return extrudeLineSegTo3D(x,y, x,y+ht, lowY, highY);
      case 2:
        return extrudeLineSegTo3D(x+wt,y, x+wt,y+ht, lowY, highY); 
      case 3:
        return extrudeLineSegTo3D(x,y+ht, x+wt,y+ht, lowY, highY);
      default:
        return null;
    }
  }
  
  public ArrayList<Triangle> extrudeLineSegTo3DWithWindow(
      Window window, 
      float x1, float z1, float x2, 
      float z2, float lowY, float highY
      ) {
    //Two triangles : 
    // (x1,z1)                       (x2,z2)
    // * ---------------------------- * highY
    // |  |   |                       |
    // |  |   |  (sx+spanx,sy+spany)  |
    // |  *---*                       |
    // |  |EEE|                       |
    // |  *---*                       |
    // |(sx,sy)                       |
    // |  |   |                       |
    // * ---------------------------- * lowY
    ArrayList<Triangle> res = new ArrayList<Triangle>();
    float angle = atan2((z2-z1), (x2-x1));

    float relWindowX = (x1+(window.getStartPoint().getX()*cos(angle)));
    float relWindowZ = (z1+(window.getStartPoint().getX()*sin(angle)));

    float relWindowXPlusSpanX = (relWindowX+(window.getWindowSpan().getX()*cos(angle)));
    float relWindowZPlusSpanZ = (relWindowZ+(window.getWindowSpan().getX()*sin(angle)));

    float windowYTop = lowY + window.getStartPoint().getY() + window.getWindowSpan().getY();
    float windowYBottom = lowY + window.getStartPoint().getY();

    res.addAll(getTrianglesFromSquare(x1,highY,z1, 
          relWindowX,lowY,relWindowZ)); //Leftmost

    res.addAll(getTrianglesFromSquare(relWindowX,highY,relWindowZ, 
          relWindowXPlusSpanX, windowYTop, relWindowZPlusSpanZ)); //Above window

    res.addAll(getTrianglesFromSquare(relWindowX,windowYBottom,relWindowZ, 
          relWindowXPlusSpanX, lowY, relWindowZPlusSpanZ)); //Below window

    res.addAll(getTrianglesFromSquare(relWindowXPlusSpanX, highY, relWindowZPlusSpanZ,
          x2,lowY,z2)); //Rightmost
    return res; 
  }

  public ArrayList<Triangle> extrudeWallWithWindowsOrDoors(
      Window window, float lowY, float highY) {
   
    switch(window.getWallN()) {
      case 0:
        return extrudeLineSegTo3DWithWindow(window, x,y+ht, x+wt,y+ht, lowY, highY);
      case 1:
        return extrudeLineSegTo3DWithWindow(window, x,y, x+wt,y, lowY, highY);
      case 2:
        return extrudeLineSegTo3DWithWindow(window, x+wt,y, x+wt,y+ht, lowY, highY); 
      case 3:
        return extrudeLineSegTo3DWithWindow(window, x,y, x,y+ht, lowY, highY);
      default:
        return null;
    }
  }

  public ArrayList<Triangle> getTrianglesForWall(int wallN, float lowY, float highY) {
    boolean extruded = false;
    ArrayList<Triangle> res = new ArrayList<Triangle>();
   
    for(int i=0 ; i < windows.size() ; i++) {
      if(wallN == windows.get(i).getWallN()) {
        res.addAll(extrudeWallWithWindowsOrDoors(windows.get(i), lowY, highY));
        extruded = true;
      }
    }
    
    if(! extruded) {
      res.addAll(extrudeWallFlat(wallN, lowY, highY));
    }

    return res;
  }

  public ArrayList<Point2> extrudeLineSegTo3DWithWindowTexCoords(
      Window window, 
      float x1, float z1, float x2, 
      float z2, float lowY, float highY
      ) {
    ArrayList<Point2> res = new ArrayList<Point2>();

    float angle = atan2((z2-z1), (x2-x1));

    float relWindowX = (x1+(window.getStartPoint().getX()*cos(angle)));
    float relWindowZ = (z1+(window.getStartPoint().getX()*sin(angle)));

    float relWindowXPlusSpanX = (relWindowX+(window.getWindowSpan().getX()*cos(angle)));
    float relWindowZPlusSpanZ = (relWindowZ+(window.getWindowSpan().getX()*sin(angle)));

    float windowYTop = lowY + window.getStartPoint().getY() + window.getWindowSpan().getY();
    float windowYBottom = lowY + window.getStartPoint().getY();

    Point2 startPoint = new Point2(x1,z1);
    Point2 relWindowPt = new Point2(relWindowX, relWindowZ);
    Point2 relWindowPlusSpanPt = new Point2(relWindowXPlusSpanX, relWindowZPlusSpanZ);
    Point2 endPt = new Point2(x2,z2);

    //We add the texture coords individually for these squares, based on their x and y positions on the wall, from the top left.
    res.addAll(getTexCoordsFromSquare(0.0,highY, startPoint.dist(relWindowPt), lowY)); //Leftmost
    res.addAll(getTexCoordsFromSquare(startPoint.dist(relWindowPt),highY, startPoint.dist(relWindowPlusSpanPt), windowYTop)); //Above Window
    res.addAll(getTexCoordsFromSquare(startPoint.dist(relWindowPt),windowYBottom, startPoint.dist(relWindowPlusSpanPt), lowY)); //Below Window
    res.addAll(getTexCoordsFromSquare(startPoint.dist(relWindowPlusSpanPt),highY, startPoint.dist(endPt), lowY)); //Right

    return res; 
  }

  public ArrayList<Point2> extrudeWallWithWindowsOrDoorsTexCoords(Window window, float lowY, float highY) {
    switch(window.getWallN()) {
      case 0:
        return extrudeLineSegTo3DWithWindowTexCoords(window, x,y, x+wt,y, lowY, highY);
      case 1:
        return extrudeLineSegTo3DWithWindowTexCoords(window, x,y, x,y+ht, lowY, highY);
      case 2:
        return extrudeLineSegTo3DWithWindowTexCoords(window, x+wt,y, x+wt,y+ht, lowY, highY); 
      case 3:
        return extrudeLineSegTo3DWithWindowTexCoords(window, x,y+ht, x+wt,y+ht, lowY, highY);
      default:
        return null;
    }
  }

  public ArrayList<Point2> extrudeWallFlatTexCoords(int wallN, float lowY, float highY) {
    switch(wallN) {
      case 0:
        return extrudeLineSegTo3DTexCoords(x,y, x+wt,y, lowY, highY);
      case 1:
        return extrudeLineSegTo3DTexCoords(x,y, x,y+ht, lowY, highY);
      case 2:
        return extrudeLineSegTo3DTexCoords(x+wt,y, x+wt,y+ht, lowY, highY); 
      case 3:
        return extrudeLineSegTo3DTexCoords(x,y+ht, x+wt,y+ht, lowY, highY);
      default:
        return null;
    }
  }

  public ArrayList<Point2> getTexCoordsForWall(int wallN, float lowY, float highY) {
    ArrayList<Point2> res = new ArrayList<Point2>();
    boolean extruded = false;
   
    //Tell whether the window is extruded or not.
    for(int i=0 ; i < windows.size() ; i++) {
      if(wallN == windows.get(i).getWallN()) {
        res.addAll(extrudeWallWithWindowsOrDoorsTexCoords(windows.get(i), lowY, highY));
        extruded = true;
      }
    }

    if(! extruded) {
      res.addAll(extrudeWallFlatTexCoords(wallN, lowY, highY));
    }

    return res;
  }

  public void addWindow(int wallN, Point2 startPoint, Point2 span) {
    windows.add(new Window(wallN, startPoint, span));
  }

  protected void generateTriangles() {
    ArrayList<Triangle> res = new ArrayList<Triangle>();
    res.addAll(getTrianglesForWall(0, lowY, highY));
    res.addAll(getTrianglesForWall(1, lowY, highY));
    res.addAll(getTrianglesForWall(2, lowY, highY));
    res.addAll(getTrianglesForWall(3, lowY, highY));
    this.triangles = res;
  }


  protected void generateTexCoords() {
    ArrayList<Point2> res = new ArrayList<Point2>();
    res.addAll(getTexCoordsForWall(0, lowY, highY));
    res.addAll(getTexCoordsForWall(1, lowY, highY));
    res.addAll(getTexCoordsForWall(2, lowY, highY));
    res.addAll(getTexCoordsForWall(3, lowY, highY));
    this.texCoords = res;
  }
}

class CuboidRoom extends Room {
  protected ArrayList<Cuboid> cuboids;
  protected float wallWidth;

  public CuboidRoom(int x, int y, int wt, int ht, float lowY, float highY, float wallWidth) {
    super(x, y, wt, ht, lowY, highY);
    this.wallWidth = wallWidth;
  }

  protected void generateGeom() {
    generateCuboids();
    generateTriangles();
    generateNormals();
    generateTexCoords();
  }

  protected ArrayList<Cuboid> getCuboidsForWallWithWindow(
      Window window,
      float x, float y, float z,
      float depth, float ht, float len) {
    //TODO
    ArrayList<Cuboid> res = new ArrayList<Cuboid>();

    float angle;
    boolean depthGreatest = (depth>len);

    if(depthGreatest) {
      float x1 = x;
      float x2 = x+depth;
      float z1 = z;
      float z2 = z;
      angle = atan2((z2-z1), (x2-x1));
    } else {
      float x1 = x;
      float x2 = x;
      float z1 = z;
      float z2 = z+len;
      angle = atan2((z2-z1), (x2-x1));
    }

    float relWindowX = (window.getStartPoint().getX()*cos(angle));
    float relWindowZ = (window.getStartPoint().getX()*sin(angle));

    float relWindowXPlusSpanX = (relWindowX+(window.getWindowSpan().getX()*cos(angle)));
    float relWindowZPlusSpanZ = (relWindowZ+(window.getWindowSpan().getX()*sin(angle)));

    float relWindowYTop = window.getStartPoint().getY() + window.getWindowSpan().getY();
    float relWindowYBottom = window.getWindowSpan().getY();

    if(depthGreatest) {
      //Since depth greatest, we are going along x axis, so no need to care about z
      res.add(new Cuboid(x,y,z, 
            relWindowX, ht, len)); //Leftmost

      res.add(new Cuboid(x+relWindowX,y+relWindowYTop,z, 
            window.getWindowSpan().getX(), ht-relWindowYTop, len)); //Above Window

      res.add(new Cuboid(x+relWindowX,y,z, 
            window.getWindowSpan().getX(), relWindowYBottom, len)); //Below Window

      res.add(new Cuboid(x+relWindowXPlusSpanX,y,z, 
            depth-relWindowXPlusSpanX, ht, len)); //Right of window
    } else {
      //Since len greatest, we are going along z axis, so no need to care about x
      res.add(new Cuboid(x,y,z, 
            depth, ht, relWindowZ)); //Leftmost

      res.add(new Cuboid(x,y+relWindowYTop,z+relWindowZ, 
            depth, ht-relWindowYTop, window.getWindowSpan().getX())); //Above Window

      res.add(new Cuboid(x,y,z+relWindowZ, 
            depth, relWindowYBottom, window.getWindowSpan().getX())); //Below Window

      res.add(new Cuboid(x,y,z+relWindowZPlusSpanZ, 
            depth, ht, len-relWindowZPlusSpanZ)); //Right of window
    }

    return res;
  }

  protected ArrayList<Cuboid> getCuboidForWall(int wallN,
      float x, float y, float z,
      float depth, float ht, float len) {
    ArrayList<Cuboid> res = new ArrayList<Cuboid>();

    boolean extruded = false;
    for(int i=0 ; i < windows.size() ; i++) {
      if(wallN == windows.get(i).getWallN()) {
        res.addAll(getCuboidsForWallWithWindow(windows.get(i), 
              x,y,z,
              depth,ht,len));
        extruded = true;
      }
    }

    if(! extruded) {
      res.add(new Cuboid(x,y,z,depth,ht,len));
    }

    return res;
  }

  protected void generateCuboids() {
    cuboids = new ArrayList<Cuboid>();

    float roomHeight = highY - lowY;

    //alpha
    cuboids.addAll(getCuboidForWall(0, 
          x,lowY,y, 
          wallWidth,roomHeight,ht));

    //beta
    cuboids.addAll(getCuboidForWall(1,
        x,lowY,y, 
        wt,roomHeight,wallWidth));

    //gamma
    cuboids.addAll(getCuboidForWall(2,
        x+wt-wallWidth,lowY,y, 
        wallWidth,roomHeight,ht));

    //delta
    cuboids.addAll(getCuboidForWall(3,
        x,lowY,y+ht-wallWidth, 
        wt,roomHeight,wallWidth));
  }


  protected void generateTriangles() {
    this.triangles = generateTrianglesFromCuboids(cuboids);
  }

  protected void generateNormals() {
    this.normals = generateNormalsFromTriangles();
  }

  protected void generateTexCoords() {
    this.texCoords = generateTexCoordsFromCuboids(cuboids);
  }
}
 

class Plane extends Entity {
  int xMin, zMin, xMax, zMax, y;

  public Plane(int xMin, int zMin, int xMax, int zMax, int y) {
    super(Entity.PLANE_TYPE, xMin, zMin);
    this.xMin = xMin;
    this.zMin = zMin;
    this.xMax = xMax;
    this.zMax = zMax;
    this.y = y;
  }

  public void generateTriangles()
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
    res.add(new Triangle(xMin,y,zMax, xMin,y,zMin, xMax,y,zMin));
    res.add(new Triangle(xMin,y,zMax, xMax,y,zMax, xMax,y,zMin));

    this.triangles = res;
  }

  public void generateTexCoords()
  {
    ArrayList<Point2> res = new ArrayList<Point2>();
    float amount = 6.0;
    res.add(new Point2(0,amount));
    res.add(new Point2(0,0));
    res.add(new Point2(amount,0));

    res.add(new Point2(0,amount));
    res.add(new Point2(amount,amount));
    res.add(new Point2(amount,0));

    this.texCoords = res;
  }

} //End Plane


class Pillar extends Entity {
  private float radius;
  private float numSlices;
  private float totalAngle;
  private float lowY;
  private float highY;

  public Pillar(float x, float y, float radius, float lowY, float highY) {
    super(Entity.PILLAR_TYPE, x, y);
    this.radius = radius;
    this.numSlices = 20;
    //totalAngle = 360.0f;
    totalAngle = 360.0f;
    //this.widthResolution = 10;
    this.lowY = lowY;
    this.highY = highY;
  }

  public float degreeToRad(float degree) {
    float PI = 3.14159265;
    return ( (degree) * (PI / 180.0) );
  }

  protected void generateTriangles() {
    ArrayList<Triangle> res = new ArrayList<Triangle>();

    float angle = (totalAngle/numSlices);
    for (int i=0; i < numSlices ; i++) {

      float x1 = x + (cos(degreeToRad( angle * i )) * radius);
      float y1 = y + (sin(degreeToRad( angle * i )) * radius);

      if((i+1) <= numSlices) { //Defensive coding, shouldn't happen.
        float x2 = x + (cos(degreeToRad( angle * (i+1) )) * radius);
        float y2 = y + (sin(degreeToRad( angle * (i+1) )) * radius);

        System.out.println("angle*i is :  " + (angle*i));
        System.out.println("x1 " + x1 + " y1 : " + y1 + " x2: " + x2 + " y2 " + y2);

        res.addAll(extrudeLineSegTo3D(x1,y1, x2, y2, lowY, highY));
      }
    }

    this.triangles = res;
  }

  protected void generateNormals() {
    this.normals = generateNormalsFromTriangles();
  }

  protected void generateTexCoords() {
    ArrayList<Point2> res = new ArrayList<Point2>();

    float amount = 6.0;
    for (int i=0; i < numSlices; i++) {
      res.add(new Point2(0,amount));
      res.add(new Point2(0,0));
      res.add(new Point2(amount,0));

      res.add(new Point2(0,amount));
      res.add(new Point2(amount,amount));
      res.add(new Point2(amount,0));
    }

    this.texCoords = res;
  }
} //END Pillar

class GameLogic extends GameEventListener{
  protected ArrayList<Entity> entities;

  public GameLogic() {
    entities = new ArrayList<Entity>();
  }

  //Factory method
  public void createRoom(int x, int y, int w, int h) {
    //Room room = new Room(x,y,w,h, 0.0f, 2.0f);
    Room room = new CuboidRoom(x,y,w,h, 0.0f, 2.0f, 0.2f);
    room.addWindow(0, new Point2(0.4, 0.6), new Point2(0.5,0.5) );
    //room.addDoor(0, 3, 6);
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
      resultStr += e.toString();  
    }
    return resultStr;
  }

  public void outputToFile(Entity entity, String filename) {
    PrintWriter outputter = createWriter(filename); 
    outputter.print(entity.toString());
    outputter.flush();
    outputter.close();
  }

  public void init() {
//    generateGrid(7,7);
    generateOffice01(3,4,7);

    PrintWriter output = createWriter("walls.txt"); 
    String entityStr = getEntitiesAsStr(10,10,entities);
//    System.out.println("Entities:\n---\n " + entityStr + "\n---");
    output.println(entityStr);
    output.flush(); // Writes the remaining data to the file
    output.close(); // Finishes the file


    Plane ceiling = new Plane(0,0, 1000,1000, 2);
    System.out.print("Ceiling:\n---\n" + ceiling.toString() + "\n---");
    outputToFile(ceiling, "ceiling.txt");

    Plane floor = new Plane(0,0, 1000,1000, 0);
    System.out.println("Floor:\n---\n" + floor.toString() + "\n---");
    outputToFile(floor, "floor.txt");

    PrintWriter pillarOutputter = createWriter("pillars.txt"); 
    ArrayList<Entity> pillars = new ArrayList<Entity>();
    //TODO : Generate a pattern of pillars
    Pillar pillar = new Pillar(0.0,0.0, 0.5, 0.0, 2.0);
    pillars.add(pillar);
    //System.out.println("Pillar:\n---\n" + pillar.toString() + "\n---");
    System.out.println("Pillars:\n---\n" + getEntitiesAsStr(10,10,pillars) + "\n---");
    pillarOutputter.print(getEntitiesAsStr(10,10,pillars));
    pillarOutputter.flush();
    pillarOutputter.close();
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
