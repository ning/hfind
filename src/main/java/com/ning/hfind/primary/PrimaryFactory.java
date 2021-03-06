/*
 * Copyright 2010 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.hfind.primary;

import org.apache.commons.cli.Option;
import org.apache.oro.text.regex.MalformedPatternException;

class PrimaryFactory
{
    public static Primary primaryFromOption(Option o) throws MalformedPatternException
    {
        String primaryString = o.getOpt();
        String argument = o.getValue();
        return getPrimary(primaryString, argument);
    }

    private static Primary getPrimary(String primary, String argument) throws MalformedPatternException
    {
        if (primary.equals("name")) {
            return new NamePrimary(argument);
        }
        else if (primary.equals("nouser")) {
            return new NoUserPrimary();
        }
        else if (primary.equals("nogroup")) {
            return new NoGroupPrimary();
        }
        else if (primary.equals("prune")) {
            throw new IllegalArgumentException("TODO");
        }
        else if (primary.equals("perm")) {
            throw new IllegalArgumentException("TODO");
        }
        else if (primary.equals("type")) {
            return new TypePrimary(argument);
        }
        else if (primary.equals("user")) {
            return new UserPrimary(argument);
        }
        else if (primary.equals("group")) {
            return new GroupPrimary(argument);
        }
        else if (primary.equals("size")) {
            return new SizePrimary(argument);
        }
        else if (primary.equals("mtime")) {
            return new MtimePrimary(argument);
        }
        else if (primary.equals("print")) {
            return null;
        }
        else if (primary.equals("newer")) {
            throw new IllegalArgumentException("TODO");
        }
        else if (primary.equals("maxdepth")) {
            return null;
        }
        else if (primary.equals("d")) {
            return null;
        }
        else if (primary.equals("empty")) {
            return new EmptyPrimary();
        }
        else if (primary.equals("print0")) {
            return null;
        }
        else if (primary.equals("delete")) {
            return null;
        }
        else if (primary.equals("v") || primary.equals("verbose")) {
            return null;
        }
        else {
            throw new IllegalArgumentException(String.format("Primary %s (argument %s) not implemented", primary, argument));
        }
    }
}
