

def main():
    n = 13
    q = 5
    w = divMod(n,q)[1]
    z = 2*w+1
    print ('Z', end="")
    print (':', end="")
    print (z, end="")
    print ('\n', end="")


def divMod(n,q):
    return n/q,n%q

main()

