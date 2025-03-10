/*
 *     This file is part of SteemJ (formerly known as 'Steem-Java-Api-Wrapper')
 * 
 *     SteemJ is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     SteemJ is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.bittrade.libs.steemj.base.models;

/**
 * This class is the java implementation of the Steem "checksum_type" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class Checksum extends Ripemd160 {

    /** Generated serial version uid. */
    private static final long serialVersionUID = 4420141835144717006L;

    /**
     * @param hashValue
     *            The ripemd160 hash.
     */
    public Checksum(String hashValue) {
        super(hashValue);
    }
}
