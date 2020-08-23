#include<iostream>
using namespace std;
/** Problem statement:- Search an item in 2D sorted Array
 *  The idea here is to reduce the serach space to find the element effectively.
 *  We can take the advantage of the fact that the matrix is sorted.
 *  Lets say we need to search 17 in matrix[3][4] = {{1,3,8,9},{11,13,17,19},{21,25,30,33}}
 *  We can start from either top right or bottom left, if we start from 21 i.e. bottom left 
 *  in the rows above it all the values will be < 21  & in columns to the right of 21 values will we > 21 .
 *  Now we now make our decision to either move up or right & eventualy find 17. 
 **/
void serachItem(int m[3][4], int item) {
    int row = 3, col =0;
    while(row>0 && col<4) {
        int val = m[row][col];
        if(item == val){
            cout<<"Item found at row "<<row<<" and column "<<col;
            return;
        }
        if(item < val) row--;
        else col++;
    }
    cout<<"Item not found";
}
int main() {
    int matrix[3][4] = {{1,3,8,9},{11,13,17,19},{21,25,30,33}};
    serachItem(matrix,17);
    return 0;
}
