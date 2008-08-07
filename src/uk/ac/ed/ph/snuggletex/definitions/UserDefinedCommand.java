/* $Id$
 *
 * Copyright 2008 University of Edinburgh.
 * All Rights Reserved
 */
package uk.ac.ed.ph.snuggletex.definitions;

import uk.ac.ed.ph.commons.util.ObjectUtilities;
import uk.ac.ed.ph.snuggletex.internal.FrozenSlice;

/**
 * Represents a user-defined {@link Command}, i.e. one defined in the client data using
 * <tt>\\newcommand</tt>.
 * 
 * @see UserDefinedEnvironment
 * 
 * @author  David McKain
 * @version $Revision$
 */
public final class UserDefinedCommand implements Command {
 
    private final String texName;
    private final boolean allowingOptionalArgument;
    private final int argumentCount;
    private final FrozenSlice definitionSlice;
    
    public UserDefinedCommand(final String texName, final boolean allowingOptionalArgument,
            final int argumentCount, final FrozenSlice definitionSlice) {
        this.texName = texName;
        this.allowingOptionalArgument = allowingOptionalArgument;
        this.argumentCount = argumentCount;
        this.definitionSlice = definitionSlice;
    }

    public String getTeXName() {
        return texName;
    }

    public boolean isAllowingOptionalArgument() {
        return allowingOptionalArgument;
    }

    public int getArgumentCount() {
        return argumentCount;
    }

    public FrozenSlice getDefinitionSlice() {
        return definitionSlice;
    }
    
    /**
     * No constraints on argument mode with these commands.
     */
    public LaTeXMode getArgumentMode(int argumentIndex) {
        return null;
    }
    
    @Override
    public String toString() {
        return ObjectUtilities.beanToString(this);
    }
}
