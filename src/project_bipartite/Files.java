package project_bipartite;

import java.util.*;
import java.io.*;

public final class Files {
    
    public Files(String name1,String name2) throws IOException{
        
        Scanner scan=null;
        PrintWriter pw= null;
        int start,end,N;
        List<Edges> edges=new ArrayList<>() ;
        
        File file= new File(name2);
        if(!file.exists()){
            file.createNewFile();
        }
        
        try{
            scan= new Scanner(new File(name1));
            pw= new PrintWriter(file);
          }catch(Exception e){
            System.out.println("file is not found");
            System.exit(0);
         }
        
        N= 1+Integer.parseInt(scan.next());
        
        //System.out.println(N);
        
        while(scan.hasNext()){
            start= Integer.parseInt(scan.next());
            end= Integer.parseInt(scan.next());
            
       //     System.out.println(start+"->"+end);
        
         edges.add(new Edges(start, end));
        }
        
        EdgestoGraph graph = new EdgestoGraph(edges, N);
        boolean dis []= new boolean[N];
        boolean color[] = new boolean[N];
        
        dis[0] = true;
        color[0] = false;
        if (Check(graph, 1, dis, color)){
            System.out.println("It is Bipartite");
            pw.println("It is Bipartite");
            pw.close();
        }
        else{
            System.out.println("It is Not Bipartite ");
            pw.println("It is not Bipartite");
            pw.close();
        }
        
    }
    
    public boolean Check(EdgestoGraph graph, int v, boolean disc[], boolean color[])
    {
       //for (int u : graph.graph.get(v))
        for(int u:graph.graph.get(v))
        {
            if (disc[u] == false)
            {
                disc[u] = true;
                color[u] =! color[v];
                
                if (Check(graph, u, disc, color) == false)
                    return false;
            }
            else if (color[v] == color[u]) {
                return false;
            }
        }
        return true;
    }
}