/*
 * Sonar ESQL Plugin
 * Copyright (C) 2013-2017 Thomas Pohl and EXXETA AG
 * http://www.exxeta.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.exxeta.iss.sonar.esql.api.tree;

import static com.exxeta.iss.sonar.esql.utils.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.exxeta.iss.sonar.esql.api.tree.Tree.Kind;
import com.exxeta.iss.sonar.esql.tree.impl.function.RowConstructorFunctionTreeImpl;
import com.exxeta.iss.sonar.esql.utils.EsqlTreeModelTest;

public class RowConstructorFunctionTest extends EsqlTreeModelTest<RowConstructorFunctionTreeImpl>{

	@Test
	public void rowConstructorFunction() {
		assertThat(Kind.ROW_CONSTRUCTOR_FUNCTION)
		.matches("ROW('granary' AS bread, 'riesling' AS wine, 'stilton' AS cheese)");
		assertThat(Kind.SET_STATEMENT)
		.matches("SET OutputRoot.XMLNS.Data = ROW('granary' AS bread, 'riesling' AS wine, 'stilton' AS cheese);");
	}
	
	@Test
	public void modelTest() throws Exception{
		RowConstructorFunctionTreeImpl tree = parse ("ROW('granary' AS bread, 'riesling' AS wine, 'stilton' AS cheese)", Kind.ROW_CONSTRUCTOR_FUNCTION);
		assertNotNull(tree.rowKeyword());
		assertNotNull(tree.openingParenthesis());
		assertNotNull(tree.aliasedExpressions());
		assertNotNull(tree.closingParenthesis());
		
	}
	
	
}
