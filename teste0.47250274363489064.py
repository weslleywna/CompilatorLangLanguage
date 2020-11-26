

def main():
    p = type('copy', Ponto.__bases__, dict(Ponto.__dict__))
    p.x = 10.0
    p.y = 10.0
    print ('\n', end="")

class Ponto:
    def __init__(self,x,y):
        self.x = x,
        self.y = y
main()

