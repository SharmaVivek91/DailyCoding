class Distance {
    public void ShortestDistance(int[][]adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        for(int i = 1; i<=n; i++ ) {
            if(i==1) distance[i-1] = 0; else distance[i-1] = Integer.MAX_VALUE;
            visited[i-1] = false;
        }
        for(int i=0; i<n-1; i++) {
            //find the index of min value in the distance array
            int min = getMinimum(distance,visited);
            visited[min] = true;
            //find the neighbours and if its distance is less update it, we can 
            for(int j=0; j<n; j++) {
                if(adjacencyMatrix[min][j] != 0 && !visited[j] &&
                    distance[min]+adjacencyMatrix[min][j]<distance[j])
                    distance[j] = distance[min]+adjacencyMatrix[min][j];
            }
        }
    }
    public int getMinimum(int distance[],boolean[]visited){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<distance.length;i++){
            // it should not be visited
            if(distance[i]<min && !visited[i]) min = i;
        }
        return min;
    }
}
class DayThirteen {
    public static void main(String args[]) {
        int adjacencyMatrix[][] = {{0,1,3,0,0,0},{1,0,4,6,0,0},{3,4,0,8,3,0},
                                    {0,6,8,0,0,3},{0,0,3,0,0,2},{0,0,0,3,2,0}};
        Distance d = new Distance();
        d.ShortestDistance(adjacencyMatrix);
    }
}
