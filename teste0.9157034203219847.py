

def main():
    n = 13
    q = 5
    res,quo = divMod(n,q)
    print ('Q', end="")
    print (':', end="")
    print (quo, end="")
    print ('\n', end="")
    print ('R', end="")
    print (':', end="")
    print (res, end="")
    print ('\n', end="")


def divMod(n,q):
    return n/q,n%q

main()

