// Learning Processing
// Daniel Shiffman
// http://www.learningprocessing.com

// Example 16-6: Drawing a grid of squares

// Size of each cell in the grid, ratio of window size to video size
// 80 * 8 = 640
// 60 * 8 = 480
//int videoScale = 8;

// Number of columns and rows in our system
//int cols, rows;

int SCREEN_WIDTH = 640;
int SCREEN_HEIGHT = 480;
int BLOCK_HALFSIZE = 8;

class Grid
{
  private int xSize, ySize, blockSize, rows, cols;
  private int[][] blockTypes;

  public Grid(int xSize, int ySize, int blockSize)
  {
    this.xSize = xSize;
    this.ySize = ySize;
    this.blockSize = blockSize;
    this.rows = this.ySize / this.blockSize;
    this.cols = this.xSize / this.blockSize;
    this.blockTypes = new int[cols][rows];
    initBlockTypes();
  }

  public void initBlockTypes()
  {
    for (int i = 0 ; i < cols ; i++)
    {
      for (int j = 0; j < rows; j++) 
      {
        blockTypes[i][j] = 0;
      }
    }
  }

  public void draw()
  {
    // Begin loop for columns
    for (int i = 0; i < cols; i++) {
      // Begin loop for rows
      for (int j = 0; j < rows; j++) {

        // Scaling up to draw a rectangle at (x,y)
        int x = i*this.blockSize;
        int y = j*this.blockSize;
        setColor(i, j);        
        stroke(0);
        // For every column and row, a rectangle is drawn at an (x,y) location scaled and sized by videoScale.
        rect(x, y, this.blockSize, this.blockSize);
      }
    }
  }  

  public void setColor(int x, int y)
  {
    switch(blockTypes[x][y])
    {
    case 0:
      fill(255);
      break;
    case 1:
      fill(0);
      break;
    }
  }

  public void setBlockType(int x, int y, int type)
  {
    blockTypes[x][y] = type;
  }

  public void setBlockTypeRectangle(int x, int y, int type, int l, int w)
  {
    for (int i = x ; i < (x+l) ; i++)
    {
      for (int j = y ; j < (y+w) ; j++)
      {
        blockTypes[i][j] = type;
      }
    }
  }
}
/*
class Room
{
  public Room(int roomtype) 
}
*/

class App
{
  private Grid grid;
  public App()
  {
    size(SCREEN_WIDTH, SCREEN_HEIGHT);  
    this.grid = new Grid(SCREEN_WIDTH, SCREEN_HEIGHT, BLOCK_HALFSIZE);

    //grid.setBlockType(40, 10, 1);
    grid.setBlockTypeRectangle(10, 10, 1, 4, 2);
  } 

  public void draw()
  {
    this.grid.draw();
  }
}

App app;

void setup() {
  app = new App();
  // Initialize columns and rows
  //  cols = width/videoScale;
  //  rows = height/videoScale;
}

void draw() {
  app.draw();
  /*
  // Begin loop for columns
   for (int i = 0; i < cols; i++) {
   // Begin loop for rows
   for (int j = 0; j < rows; j++) {
   
   // Scaling up to draw a rectangle at (x,y)
   int x = i*videoScale;
   int y = j*videoScale;
   fill(255);
   stroke(0);
   // For every column and row, a rectangle is drawn at an (x,y) location scaled and sized by videoScale.
   rect(x,y,videoScale,videoScale); 
   }
   }
   */
}

