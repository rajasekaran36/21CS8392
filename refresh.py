import os

pathsfile = open("allpaths.txt","w")
def list_files(startpath):
    for root, dirs, files in os.walk(startpath):
            if(not str(root).startswith('.\.')):
                pathsfile.write(str(root)+"\n")
                print(str(root))
list_files(".")