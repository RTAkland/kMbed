/*
 * Copyright 2025 Karma Krafts & associates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.karma.kmbed.gradle

import org.intellij.lang.annotations.Language
import java.util.*

internal class SourceBuilder {
    private val builder: StringBuilder = StringBuilder()
    private var indentStack: Stack<Int> = Stack()
    private var currentIndent: Int = 0

    fun append(@Language("kotlin") s: String) {
        for (i in 0..<currentIndent) {
            builder.append('\t')
        }
        builder.append(s)
    }

    fun line(@Language("kotlin") s: String) = append("$s\n")

    fun newline() {
        builder.append('\n')
    }

    fun pushIndent() {
        indentStack.push(currentIndent)
        currentIndent++
    }

    fun pushIndent(indent: Int) {
        indentStack.push(currentIndent)
        currentIndent = indent
    }

    fun popIndent() {
        currentIndent = indentStack.pop()
    }

    fun render(): String = builder.toString()
}