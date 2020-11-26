

def printP(p):
    print ('(', end="")
    print (p.x, end="")
    print (',', end="")
    print (p.y, end="")
    print (')', end="")


def printV(v,n):
    print ('{', end="")
    if 0<n:
    		printP(v[0])
    		i = 1
    		for iterate in range(n-1):
    				print (',', end="")
    				printP(v[i])
    				i = i+1
    				
    		
    print ('}', end="")


def sort(v,n):
    i = 0
    for iterate in range(n-1):
    		j = i+1
    		for iterate in range(n-(i+1)):
    				if v[i].x<v[j].x:
    						aux = v[i]
    						v[i] = v[j]
    						v[j] = aux
    						
    				j = j+1
    				
    		i = i+1
    		


def main():
    k = 5
    p = [None] * k
    i = 0
    for iterate in range(k):
    		p[i] = type('copy', Ponto.__bases__, dict(Ponto.__dict__))
    		p[i].x = 12+i
    		p[i].y = 12-i
    		i = i+1
    		
    printV(p,k)
    sort(p,k)
    print ('\n', end="")
    printV(p,k)
    print ('\n', end="")

class Ponto:
    def __init__(self,x,y):
        self.x = x,
        self.y = y
main()

