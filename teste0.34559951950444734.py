

def f(x):
    y = 2*x+1
    if y<10:
    	return y,1.5
    else:
    	return y,1.5


def main():
    z = 10
    h = 2*f(z)[0]+f(z)[1]

main()

