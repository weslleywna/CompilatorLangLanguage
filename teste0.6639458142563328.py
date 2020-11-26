

def main():
    k = 5
    x = [None] * k
    i = 0
    for iterate in range(k):
    		x[i] = [None] * k
    		i = i+1
    		
    i = 0
    for iterate in range(k):
    		x[i][i] = 2*i+1
    		i = i+1
    		
    z = x[3][3]

main()

