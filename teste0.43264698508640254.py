

def main():
    k = 5
    p = [None] * k
    i = 0
    for iterate in range(k):
    		p[i] = type('copy', Ponto.__bases__, dict(Ponto.__dict__))
    		p[i].x = 12+i
    		p[i].y = 12-i
    		i = i+1
    		
    print ('\n', end="")

class Ponto:
    def __init__(self,x,y):
        self.x = x,
        self.y = y
main()

