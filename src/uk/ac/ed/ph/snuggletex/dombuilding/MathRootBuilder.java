/* $Id: MathComplexCommandBuilder.java 12 2008-05-06 21:17:06Z davemckain $
 *
 * Copyright 2008 University of Edinburgh.
 * All Rights Reserved
 */
package uk.ac.ed.ph.snuggletex.dombuilding;

import uk.ac.ed.ph.snuggletex.conversion.DOMBuilder;
import uk.ac.ed.ph.snuggletex.conversion.SnuggleParseException;
import uk.ac.ed.ph.snuggletex.tokens.ArgumentContainerToken;
import uk.ac.ed.ph.snuggletex.tokens.CommandToken;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/**
 * Handles the LaTeX <tt>\sqrt</tt> command, which generates either a <tt>msqrt</tt>
 * or <tt>mroot</tt> depending on whether an optional argument has been passed or not.
 *
 * @author  David McKain
 * @version $Revision: 12 $
 */
public final class MathRootBuilder implements CommandHandler {
    
    public void handleCommand(DOMBuilder builder, Element parentElement, CommandToken token)
            throws DOMException, SnuggleParseException {
        ArgumentContainerToken optionalArgument = token.getOptionalArgument();
        ArgumentContainerToken requiredArgument = token.getArguments()[0];
        Element result;
        if (optionalArgument!=null) {
            /* Has optional argument, so generate <mroot/> */
            result = builder.appendMathMLElement(parentElement, "mroot");
            builder.handleMathTokensAsSingleElement(result, requiredArgument);
            builder.handleMathTokensAsSingleElement(result, optionalArgument);
        }
        else {
            /* No optional argument, so do <msqrt/> */
            result = builder.appendMathMLElement(parentElement, "msqrt");
            builder.handleMathTokensAsSingleElement(result, requiredArgument);
        }
    }
}
