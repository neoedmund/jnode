/*
 * Copyright 1997-1998 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

package javax.swing.plaf;


/** 
 * This interface is used to mark objects created by ComponentUI delegates.
 * The <code>ComponentUI.installUI()</code> and 
 * <code>ComponentUI.uninstallUI()</code> methods can use this interface
 * to decide if a properties value has been overridden.  For example, the
 * JList cellRenderer property is initialized by BasicListUI.installUI(),
 * only if it's initial value is null:
 * <pre>
 * if (list.getCellRenderer() == null) {
 *     list.setCellRenderer((ListCellRenderer)(UIManager.get("List.cellRenderer")));
 * }
 * </pre>
 * At uninstallUI() time we reset the property to null if its value
 * is an instance of UIResource:
 * <pre>
 * if (list.getCellRenderer() instanceof UIResource) {
 *     list.setCellRenderer(null);
 * }
 *</pre>
 * This pattern applies to all properties except the java.awt.Component
 * properties font, foreground, and background.  If one of these
 * properties isn't initialized, or is explicitly set to null, 
 * its container provides the value.  For this reason the 
 * <code>"== null"</code> is unreliable when installUI() is called
 * to dynamically change a components look and feel.  So at installUI() 
 * time we check to see if the current value is a UIResource:
 *<pre>
 * if (!(list.getFont() instanceof UIResource)) {
 *     list.setFont(UIManager.getFont("List.font"));
 * }
 * </pre>
 *
 * @see ComponentUI
 * @version 1.17 05/05/07
 * @author Hans Muller
 * 
 */

public interface UIResource {
}