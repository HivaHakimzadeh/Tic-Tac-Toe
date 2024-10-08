/******************************************************************************
Tic Tac Toe Game: The program prompts the first user who is on default "player X"
to enter the field number which the program replaces with the letter X, and then
the program prompts the second player who is "player O" to do the same. At the end
the program will count the number of rows, columns, and/or diagonal lines that is 
filled with all Os or Xs, and returns the scores of each player.

creatd by: Hiva Hakimzadeh 06/01/2022
*******************************************************************************/
#include <iostream>
#include <cstdlib>
using namespace std;
char gamer='X';
char matrix[3][3]={'1','2','3','4','5','6','7','8','9'};

//this function draws a chart with 3 rows and colunms each numbered from 1 through 9
void Draw()
{
    cout<<"Tic Tac Toe Game\n";
    for(int i=0;i<3;i++)
    {
        for(int j=0;j<3;j++)
        {
            cout<<matrix[i][j]<<" ";
        }
        cout<<endl;
    }
}
//prompts the user to enter the field number, and replaces that field number with the player's letter
void prompt()
{
    cout<<"please enter the field number of choice:";
    int input;
    cin>>input;
    
    if (input==1)
        matrix[0][0]=gamer;
    
    else if(input==2)
        matrix[0][1]=gamer;
     
    else if(input==3)
        matrix[0][2]=gamer;
    
     
    else if(input==4)
        matrix[1][0]=gamer;
    
    else if(input==5)
        matrix[1][1]=gamer;
    
    else if(input==6)
        matrix[1][2]=gamer;
    
     
    else if(input==7)
        matrix[2][0]=gamer;
    
    else if(input==8)
        matrix[2][1]=gamer;
     
    else if(input==9)
        matrix[2][2]=gamer;
     
}
/* recognized different possibilities where can gain point. This function checks if the player
 can earn points, and if so it will add up the points for each player, and return the count
 the possibilities:
 1 2 3
 4 5 6
 7 8 9
 if player is in 1 2 3 ,or  4 5 6,or  7 8 9 
 if player is in 1 4 7,or  2 5 8,or  3 6 9
 if player 1 5 9, 3 5 7 
 */
int check(int player)
{
    int count=0;
    int i=0;
    for(int j=0;j<3;j++)
    {
        if(matrix[i][j] ==player && matrix[i+1][j]==player && matrix[i+2][j]==player)
          count++;
    }
    for (int b=0;b<3;b++)
    {
        int c =0;
        if(matrix[b][c] ==player && matrix[b][c+1]==player && matrix[b][c+2]==player)
          count++;
    }
    
   if(matrix[0][0] ==player && matrix[1][1]==player && matrix[2][2]==player)
        count++;
   if(matrix[2][0] ==player && matrix[1][1]==player && matrix[0][2]==player)
        count++;
 return count;
    
}

//this function switches the turns of the players, by checking who went last and who has to go next
void SwitchPlayers()
{
    if(gamer=='X')
        gamer='O';
    else 
        gamer='X';
}
/*this function checks to see if the game is over or not. The game is over when all the fields are filled
with either X or O
*/
bool Gameover()
{
    bool over=true;
    for( int a=0; a<3; a++)
    {
        for(int b=0; b<3; b++)
        {
            if(matrix[a][b] !='X' &&  matrix[a][b] !='O' )
            {
            over=false;
            break;
            }
            else
            continue;
        }
    }
    return over;
}
// The main funcion where all the other functions are called and put together to print the final result
int main()
{
  int win;
  Draw();
  while(!Gameover())
  {
      prompt();
      Draw();
      SwitchPlayers();
  }
  win=check(gamer);
  cout<<" Game Over. Player: " << gamer <<" scored: "<<win<< endl;
  SwitchPlayers();
  cout<<" Player: "<< gamer <<" scored: "<<check(gamer);
  //system("pause");
  return 0;
}
