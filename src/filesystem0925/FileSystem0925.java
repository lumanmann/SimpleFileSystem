/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem0925;

import java.util.Scanner;

/**
 *
 * @author wingyiu
 */
public class FileSystem0925 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        Directory current = new Directory("root");
        current.printAddress();
        System.out.print("> ");
        
        while (true) {
            
            String command = scanner.nextLine();
            String[] arrS = command.split(" ");
            
            
            switch(arrS[0]) {
                case "cd":
                    boolean isFound = false;
                    for (int i = 0; i < current.getItemCount(); i++) {
                        
                        if (arrS[1].equals(current.getDirListItem(i).getName())) {
                            isFound = true;
                            
                            if ( current.getDirListItem(i) instanceof Directory){  
                                current = (Directory)current.getDirListItem(i);
                            } else {
                                System.out.println(arrS[0] + " " + "Not a Directory");
                            }
                            
                        } 
                    }
                    
                    if (isFound == false) {             
                        System.out.println(arrS[1] + " " + "Not found");                  
                    }  
                    break;
                
                case "cd..":
                    current = current.getParent();
                    break;
                    
                case "touch":               
                    current.addFile(arrS[1]);
                    break; 
                    
                case "mkdir":
                    current.addDirectory(arrS[1]);
                    break;
                    
                case "ls":
                    current.printDirList();
                    break;
                    
                case "search":
                    Directory tmp = current;
                    while (tmp.getParent() != null) {
                        tmp = tmp.getParent();
                    }
                    tmp.search(arrS[1]);
                    break;
                    
                default:
                    System.out.println("command not found");
            }
            
            current.printAddress();
            System.out.print("> ");
            
            
        }
                
        
        
        
    }
    
}
