/*
 * Librarian
 * Copyright (C) 2021 ParchmentMC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.parchmentmc.librarian;

import net.minecraftforge.gradle.mcp.ChannelProviders;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class LibrarianPlugin implements Plugin<Project> {
    private static final ParchmentChannelProvider PARCHMENT_PROVIDER = new ParchmentChannelProvider();

    @Override
    public void apply(Project project) {
        project.getRepositories().maven(repo -> {
            repo.setName("ParchmentMC");
            repo.setUrl("https://maven.parchmentmc.org/");
            repo.mavenContent(filter -> filter.includeGroupByRegex("org\\.parchmentmc.*"));
        });

        ChannelProviders.addProvider(PARCHMENT_PROVIDER);
    }
}
