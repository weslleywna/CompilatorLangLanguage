/*
 Vitor Hugo Nascimento Pinto - 201535008
 Weslley Nascimento Araujo - 201535001
*/

package lang.parser.implementation;

import lang.ast.SuperNode;

public class Node extends SuperNode {
    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }
}
