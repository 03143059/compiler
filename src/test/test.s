<?xml version="1.0"?>
<Program classname="Program">
  <Fields>
      <Single type="Int">a</Single>
      <Single type="Int">b</Single>
      <Array size="3" type="Int">c</Array>
  </Fields>
  <Methods>
      <Method type="BOOLEAN" name="gcd">
        <MethodParams>
          <MethodParam type="INT">a</MethodParam>
          <MethodParam type="INT">b</MethodParam>
        </MethodParams>
        <Statements>
            <If>
              <Expression>
                <BinaryOperation operator="==">
                  <LeftExpression>
                  <Id>b</Id>
                  </LeftExpression>
                  <RightExpression>
                  <Int>0</Int>
                  </RightExpression>
                </BinaryOperation>
              </Expression>
              <Then>
                <Statements>
                    <ReturnExpression>
                      <ExpressionGroup>
                          <Id>a</Id>
                      </ExpressionGroup>
                    </ReturnExpression>
                </Statements>
              </Then>
              <Else>
                <Statements>
                    <ReturnExpression>
                      <ExpressionGroup>
                          <MethodCall method="gcd">
                            <Parameters>
                                <Id>b</Id>
                                <BinaryOperation operator="%">
                                  <LeftExpression>
                                  <Id>a</Id>
                                  </LeftExpression>
                                  <RightExpression>
                                  <Id>b</Id>
                                  </RightExpression>
                                </BinaryOperation>
                            </Parameters>
                          </MethodCall>
                      </ExpressionGroup>
                    </ReturnExpression>
                </Statements>
              </Else>
            </If>
        </Statements>
      </Method>
      <Method type="BOOLEAN" name="test">
        <Variables>
            <Variable type="INT">i</Variable>
        </Variables>
        <Statements>
            <For variable="i>
              <Start>
                <Int>0</Int>
              </Start>
              <End>
                <Int>2</Int>
              </End>
              <Block>
                <Statements>
                    <Assignment operator="Equal">
                      <Location>
                        <Array name="c">
                          <Index>
                            <Id>i</Id>
                          </Index>
                        </Array>
                      </Location>
                      </Expression>
                        <BinaryOperation operator="*">
                          <LeftExpression>
                          <Id>i</Id>
                          </LeftExpression>
                          <RightExpression>
                          <Id>i</Id>
                          </RightExpression>
                        </BinaryOperation>
                      </Expression>
                    </Assignment>
                </Statements>
              </Block>
            </For>
            <ReturnExpression>
              <Boolean>true</Boolean>
            </ReturnExpression>
        </Statements>
      </Method>
      <Method type="VOID" name="test2">
        <Statements>
            <ReturnExpression/>
        </Statements>
      </Method>
      <Method type="BOOLEAN" name="main">
        <Variables>
            <Variable type="INT">x</Variable>
            <Variable type="INT">y</Variable>
            <Variable type="INT">z</Variable>
        </Variables>
        <Statements>
            <Assignment operator="Equal">
              <Location>
                <Id>a</Id>
              </Location>
              </Expression>
                <Char>d</Char>
              </Expression>
            </Assignment>
            <Assignment operator="Equal">
              <Location>
                <Id>b</Id>
              </Location>
              </Expression>
                <Int>20</Int>
              </Expression>
            </Assignment>
            <Assignment operator="Equal">
              <Location>
                <Id>x</Id>
              </Location>
              </Expression>
                <Id>a</Id>
              </Expression>
            </Assignment>
            <Assignment operator="Equal">
              <Location>
                <Id>y</Id>
              </Location>
              </Expression>
                <Id>b</Id>
              </Expression>
            </Assignment>
            <Assignment operator="Equal">
              <Location>
                <Id>z</Id>
              </Location>
              </Expression>
                <MethodCall method="gcd">
                  <Parameters>
                      <Id>x</Id>
                      <Id>y</Id>
                  </Parameters>
                </MethodCall>
              </Expression>
            </Assignment>
            <Callout functionName="printf">
              <Arguments>
                <String>%c</String>
                <Expression>
                  <Id>a</Id>
                </Expression>
              </Arguments>
            </Callout>
            <Callout functionName="print_int">
              <Arguments>
                <Expression>
                  <Id>z</Id>
                </Expression>
              </Arguments>
            </Callout>
            <ReturnExpression>
              <Int>0</Int>
            </ReturnExpression>
        </Statements>
      </Method>
  </Methods>
</Program>
