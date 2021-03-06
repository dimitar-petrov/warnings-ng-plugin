package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.IarParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import org.jenkinsci.Symbol;
import hudson.Extension;

/**
 * Provides a parser and customized messages for the IAR C/C++ compiler.
 *
 * @author Ullrich Hafner
 */
public class Iar extends StaticAnalysisTool {
    private static final long serialVersionUID = 6672928932731913714L;
    static final String ID = "iar";

    /** Creates a new instance of {@link Iar}. */
    @DataBoundConstructor
    public Iar() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public IarParser createParser() {
        return new IarParser();
    }

    /** Descriptor for this static analysis tool. */
    @Symbol("iar")
    @Extension
    public static class Descriptor extends StaticAnalysisToolDescriptor {
        /** Creates the descriptor instance. */
        public Descriptor() {
            super(ID);
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Warnings_iar_ParserName();
        }

        @Override
        public String getHelp() {
            return "The IAR compilers need to be started with option <strong>--no_wrap_diagnostics</strong>. "
                    + "Then the IAR compilers will create single-line warnings.";
        }
    }
}
