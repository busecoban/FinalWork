/*
 * A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:

't' that evaluates to true.
'f' that evaluates to false.
'!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
'&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
'|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
Given a string expression that represents a boolean expression, return the evaluation of that expression.

It is guaranteed that the given expression is valid and follows the given rules.

Input: expression = "&(|(f))"
Output: false
Explanation: 
First, evaluate |(f) --> f. The expression is now "&(f)".
Then, evaluate &(f) --> f. The expression is now "f".
Finally, return false.

 */




public class parsingBooleanExpression_1106 {
    private int idx = 0;

    public boolean parseBoolExpr(final String expression) {
        this.idx = 0;

        if(expression.length() == 1)
            return expression.charAt(0) == 't';
        
        return this.helper(expression);
    }

    private boolean helper(final String s) {
        final char operator = s.charAt(this.idx);

        this.idx += 2;
        
        char c = s.charAt(this.idx);

        boolean result = false;

        if(c == 't') {
            result = true;
            this.idx++;
        } else if(c == 'f') {
            result = false;
            this.idx++;
        } else {
            result = this.helper(s);
        }

        c = s.charAt(this.idx);

        while(c != ')') {
            if(c == ',') {
                c = s.charAt(++this.idx);
                continue;
            }

            boolean curr = false;

            if(c == 't') {
                curr = true;
                this.idx++;
            } else if(c == 'f') {
                curr = false;
                this.idx++;
            } else {
                curr = helper(s);
            }

            if(operator == '&')
                result &= curr;
            else if(operator == '|')
                result |= curr;

            c = s.charAt(this.idx);
        }

        this.idx++;

        return operator == '!' ? !result : result;
    
    }

    public static void main(String args[]) {
        parsingBooleanExpression_1106 ob = new parsingBooleanExpression_1106();
        String expression = "&(|(f))";
        System.out.println(ob.parseBoolExpr(expression));
    }
}

 