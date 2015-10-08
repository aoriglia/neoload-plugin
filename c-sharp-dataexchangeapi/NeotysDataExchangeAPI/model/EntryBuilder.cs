﻿using System.Collections.Generic;
using Neotys.DataExchangeAPI.UtilsFromJava;

/*
 * Copyright (c) 2015, Neotys
 * All rights reserved.
 */
namespace Neotys.DataExchangeAPI.Model
{

	/// <summary>
	/// Builder for object <seealso cref="Entry"/>.
	/// 
	/// @author srichert
	/// 
	/// </summary>
	public class EntryBuilder
	{
		private readonly IList<string> path;
        private readonly long _timestamp;
        public long Timestamp { get { return _timestamp; } }

        public double? Value { get; set; }
        public string Url { get; set; }
		public string Unit { get; set; }
        public Status Status { get; set; }

        // Used for the CurrentTimeMilliseconds() method.
        private static readonly System.DateTime java1970 = new System.DateTime(1970, 1, 1, 0, 0, 0, System.DateTimeKind.Utc);

        /// 
        /// <param name="pathArgument"> </param>
        /// <param name="timestamp"> </param>
        /// <exception cref="NullPointerException"> if the path is null. </exception>
        public EntryBuilder(IList<string> pathArgument, long timestamp)
        {
            this.path = Preconditions.CheckNotNull<IList<string>>(pathArgument);
            this._timestamp = timestamp;
        }

        /// 
        /// <param name="pathArgument"> </param>
        /// <exception cref="NullPointerException"> if the path is null. </exception>
        public EntryBuilder(IList<string> pathArgument)
        {
            this.path = Preconditions.CheckNotNull<IList<string>>(pathArgument);
            this._timestamp = CurrentTimeMilliseconds();
        }

        public Entry Build()
		{
			return new Entry(this);
		}

		internal virtual IList<string> Path
		{
			get
			{
				return path;
			}
		}

        /** Return the current time in the same way java does System.currentTimeMilliseconds();. */
        public static long CurrentTimeMilliseconds()
        {
            return (long)System.DateTime.Now.ToUniversalTime().Subtract(java1970).TotalMilliseconds;
        }

    }

}