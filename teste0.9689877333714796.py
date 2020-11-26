

def main():
    k = 4
    x = [None] * k
    x[0] = 0
    x[3] = 15
    print (x[3], end="")
    print ('\n', end="")
    i = 0
    for iterate in range(k):
    		if i%2==0:
    				x[i] = 2*i
    				
    		else:
    				x[i] = 2*i+1
    				
    		i = i+1
    		
    i = 0
    print ('{', end="")
    if 0<k:
    		print (x[0], end="")
    		for iterate in range(k-1):
    				print (',', end="")
    				print (x[i+1], end="")
    				i = i+1
    				
    		
    print ('}', end="")
    print ('\n', end="")

main()

