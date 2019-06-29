package eu.bittrade.libs.steemj.protocol.enums;

public class AssetSymbolSpace {
/*    enum asset_symbol_space
    {
       legacy_space = 1,
       smt_nai_space = 2
    };
    
    // buf must have space for STEEM_ASSET_SYMBOL_MAX_LENGTH+1
    static asset_symbol_type from_string( const char* buf, uint8_t decimal_places );
    static asset_symbol_type from_asset_num( uint32_t asset_num )
    {   asset_symbol_type result;   result.asset_num = asset_num;   return result;   }
    static uint32_t asset_num_from_nai( uint32_t nai, uint8_t decimal_places );
    static asset_symbol_type from_nai( uint32_t nai, uint8_t decimal_places )
    {   return from_asset_num( asset_num_from_nai( nai, decimal_places ) );          }

    void to_string( char* buf )const;
    std::string to_string()const
    {
       char buf[ STEEM_ASSET_SYMBOL_MAX_LENGTH+1 ];
       to_string( buf );
       return std::string(buf);
    }
    uint32_t to_nai()const;

    asset_symbol_space space()const;
    uint8_t decimals()const
    {  return uint8_t( asset_num & 0x0F );    }
    void validate()const;

    friend bool operator == ( const asset_symbol_type& a, const asset_symbol_type& b )
    {  return (a.asset_num == b.asset_num);   }
    friend bool operator != ( const asset_symbol_type& a, const asset_symbol_type& b )
    {  return (a.asset_num != b.asset_num);   }
    friend bool operator <  ( const asset_symbol_type& a, const asset_symbol_type& b )
    {  return (a.asset_num <  b.asset_num);   }
    friend bool operator >  ( const asset_symbol_type& a, const asset_symbol_type& b )
    {  return (a.asset_num >  b.asset_num);   }
    friend bool operator <= ( const asset_symbol_type& a, const asset_symbol_type& b )
    {  return (a.asset_num <= b.asset_num);   }
    friend bool operator >= ( const asset_symbol_type& a, const asset_symbol_type& b )
    {  return (a.asset_num >= b.asset_num);   }

    uint32_t asset_num = 0;*/
}
