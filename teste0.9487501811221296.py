

def fat(n):
    if n==0:
    		return 1
    		
    return n*fat(n-1)[0]


def spook(n):
    if n==1:
    		return 2*n
    		
    if n==2:
    		return 2*n+1
    		
    return n-1


def main():
    k = spook(2)
    print (k, end="")
    print ('\n', end="")

main()

