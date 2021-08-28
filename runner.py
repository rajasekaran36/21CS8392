import os
project_root = open("torun.txt").read().splitlines()[0]
os.chdir(project_root)
os.system("javac Main.java")
os.system("java Main")
